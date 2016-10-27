package com.myspring.ioc.aop;

import com.myspring.ioc.HelloWorldService;
import com.myspring.ioc.HelloWorldServiceImpl;
import com.myspring.ioc.context.ApplicationContext;
import com.myspring.ioc.context.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * Created by shulin on 16/10/24.
 */
public class JdkDynamicAopProxyTest {

    @Test
    public void testInterceptor() throws Exception{
        //without aop
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("myspring.xml");
        HelloWorldService helloWorldService = (HelloWorldServiceImpl)applicationContext.getBean("helloWorldService");
        helloWorldService.sayHello();


        //with aop
        //设置被代理对象
        AdvisedSupport advised = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(helloWorldService,HelloWorldService.class);
        advised.setTargetSource(targetSource);
        //设置拦截器
        TimeInterceptor timeInterceptor = new TimeInterceptor();
        advised.setMethodInterceptor(timeInterceptor);
        //创建代理
        JdkDynamicAopProxy proxy = new JdkDynamicAopProxy(advised);
        HelloWorldService helloWorldServiceProxy = (HelloWorldService)proxy.getProxy();
        helloWorldServiceProxy.sayHello();


    }
}
