package com.myspring.ioc.aop;

import com.myspring.ioc.CglibService;
import com.myspring.ioc.HelloWorldService;
import com.myspring.ioc.HelloWorldServiceImpl;
import com.myspring.ioc.context.ApplicationContext;
import com.myspring.ioc.context.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * Created by shulin on 16/10/27.
 */
public class CglibAopProxyTest {

    @Test
    public void cglibAopProxyTest() throws Exception{
// --------- helloWorldService without AOP
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("myspring-cglib.xml");
        CglibService cglibService =(CglibService) applicationContext.getBean("cglibService");
        cglibService.say();


        // --------- helloWorldService with AOP
        // 1. 设置被代理对象(Joinpoint)
        AdvisedSupport advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(cglibService, CglibService.class,
                CglibService.class);
        advisedSupport.setTargetSource(targetSource);

        // 2. 设置拦截器(Advice)
        TimeInterceptor timerInterceptor = new TimeInterceptor();
        advisedSupport.setMethodInterceptor(timerInterceptor);

        // 3. 创建代理(Proxy)
        CglibAopProxy cglib2AopProxy = new CglibAopProxy(advisedSupport);
        CglibService cglibServiceProxy = (CglibService) cglib2AopProxy.getProxy();

        // 4. 基于AOP的调用
        cglibServiceProxy.say();

    }
}
