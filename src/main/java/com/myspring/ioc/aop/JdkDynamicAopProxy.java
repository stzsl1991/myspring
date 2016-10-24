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
        MethodInterceptor m = advisedSupport.getMethodInterceptor();
        ReflectiveMethodInvocation reflectiveMethodInvocation = new ReflectiveMethodInvocation(advisedSupport.getTargetSource().getTarget(),method,args);
        return m.invoke(reflectiveMethodInvocation);
    }
}
