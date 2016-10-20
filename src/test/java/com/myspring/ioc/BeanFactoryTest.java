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
    public void test(){
        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName(beanClassName);
        beanFactory.registerBeanDefinition(beanName, beanDefinition);
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean(beanName);
        helloWorldService.sayHello();
    }
}
