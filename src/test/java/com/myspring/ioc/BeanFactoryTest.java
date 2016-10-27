package com.myspring.ioc;

import com.myspring.ioc.beans.BeanDefinition;
import com.myspring.ioc.beans.xml.XmlBeanDefinitionReader;
import com.myspring.ioc.beans.factory.AbstractBeanFactory;
import com.myspring.ioc.beans.factory.AutowireCapableBeanFactory;
import com.myspring.ioc.beans.io.ResourceLoader;
import org.junit.Test;

import java.util.Map;

/**
 * Created by shulin on 16/10/20.
 */
public class BeanFactoryTest {
    private String outputBeanName = "outputService";
    private String helloBeanName  = "helloWorldService";

    @Test
    public void test() throws Exception{
        //1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("myspring.xml");
        //2.初始化BeanFactory
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        //3.注册Bean
        for (Map.Entry<String,BeanDefinition> entry : xmlBeanDefinitionReader.getRegistry().entrySet()){
            beanFactory.registerBeanDefinition(entry.getKey(),entry.getValue());
        }
        //4.提前实例化Bean。如果调用，那么就是延迟加载
//        beanFactory.preInstantiateSingletons();

        HelloWorldServiceImpl helloWorldService = (HelloWorldServiceImpl) beanFactory.getBean(helloBeanName);
        helloWorldService.sayHello();

        OutputServiceImpl outputService = (OutputServiceImpl) beanFactory.getBean(outputBeanName);
        outputService.modifyName();
        outputService.say();
    }
}
