package com.myspring.ioc;

import org.junit.Test;

/**
 * Created by shulin on 16/10/20.
 */
public class BeanFactoryTest {

    @Test
    public void test(){
        BeanFactory beanFactory = new BeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(new HelloWorldService());
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.sayHello();
    }
}
