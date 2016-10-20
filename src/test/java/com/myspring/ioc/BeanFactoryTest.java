package com.myspring.ioc;

import com.myspring.ioc.factory.AutowireCapableBeanFactory;
import com.myspring.ioc.factory.BeanFactory;
import org.junit.Test;

/**
 * Created by shulin on 16/10/20.
 */
public class BeanFactoryTest {
    private String beanName  = "helloWorldService";
    private String beanClassName = "com.myspring.ioc.HelloWorldService";

    @Test
    public void test() throws Exception{
        //1.初始化工厂
        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        //2.bean定义
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName(beanClassName);

        //3.设置属性
        PropertyValues propertyValues = new PropertyValues();
        PropertyValue name = new PropertyValue("name","小明");
        PropertyValue word = new PropertyValue("word","你们好！");
        propertyValues.addPropertyValue(name);
        propertyValues.addPropertyValue(word);

        beanDefinition.setPropertyValues(propertyValues);
        //4.生成bean
        beanFactory.registerBeanDefinition(beanName, beanDefinition);
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean(beanName);
        helloWorldService.sayHello();
    }
}
