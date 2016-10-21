package com.myspring.ioc;

import com.myspring.ioc.bean.BeanDefinition;
import com.myspring.ioc.bean.xml.XmlBeanDefinitionReader;
import com.myspring.ioc.factory.AbstractBeanFactory;
import com.myspring.ioc.factory.AutowireCapableBeanFactory;
import com.myspring.ioc.factory.BeanFactory;
import com.myspring.ioc.io.ResourceLoader;
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
        //4.初始化Bean
        beanFactory.preInstantiateSingletons();

        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean(helloBeanName);
        helloWorldService.sayHello();

        OutputService outputService = (OutputService) beanFactory.getBean(outputBeanName);
        outputService.modifyName();
        outputService.say();


    }
}
