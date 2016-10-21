package com.myspring.ioc.context;

import com.myspring.ioc.HelloWorldService;
import com.myspring.ioc.OutputService;
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
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean(helloBeanName);
        helloWorldService.sayHello();

        OutputService outputService = (OutputService) applicationContext.getBean(outputBeanName);
        outputService.modifyName();
        outputService.say();
    }
}
