package com.myspring.ioc.context;

import com.myspring.ioc.HelloWorldServiceImpl;
import com.myspring.ioc.OutputServiceImpl;
import org.junit.Test;

/**
 * Created by shulin on 16/10/20.
 */
public class ApplicationContextTest {
    private String outputBeanName = "outputService";
    private String helloBeanName  = "helloWorldService";

    @Test
    public void test() throws Exception{
        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("myspring.xml");
        HelloWorldServiceImpl helloWorldService = (HelloWorldServiceImpl) applicationContext.getBean(helloBeanName);
        helloWorldService.sayHello();

        OutputServiceImpl outputService = (OutputServiceImpl) applicationContext.getBean(outputBeanName);
        outputService.modifyName();
        outputService.say();
    }

    /**
     * 测试aspectj管理的切面
     * @throws Exception
     */
    @Test
    public void testBeanProcess() throws Exception{
        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("myspring2.xml");
        HelloWorldServiceImpl helloWorldService = (HelloWorldServiceImpl) applicationContext.getBean(helloBeanName);
        helloWorldService.sayHello();
    }
}
