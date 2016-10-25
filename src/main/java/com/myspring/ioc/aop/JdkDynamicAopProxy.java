package com.myspring.ioc.aop;

import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by shulin on 16/10/24.
 */
public class JdkDynamicAopProxy implements AopProxy,InvocationHandler {

    private AdvisedSupport advisedSupport;

    public JdkDynamicAopProxy(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    @Override
    public Object getProxy() {
        return Proxy.newProxyInstance(getClass().getClassLoader(),new Class[]{advisedSupport.getTargetSource().getTargetClass()},this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //如果按照JDK自带的动态代理，此处需要硬编码，而使用了aopalliance这个AOP联盟提供的
        //API包，可以将这部分硬编码解耦和，从而产生方法拦截器这么个类
//        System.out.println("before-----------");
//        Object object = method.invoke(advisedSupport.getTargetSource().getTarget(),args);
//        System.out.println("after------------");
//        return object;
        MethodInterceptor m = advisedSupport.getMethodInterceptor();
        ReflectiveMethodInvocation reflectiveMethodInvocation = new ReflectiveMethodInvocation(advisedSupport.getTargetSource().getTarget(),method,args);
        return m.invoke(reflectiveMethodInvocation);
    }
}
