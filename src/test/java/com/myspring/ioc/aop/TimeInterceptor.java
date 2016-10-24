package com.myspring.ioc.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by shulin on 16/10/24.
 */
public class TimeInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        long time = System.nanoTime();
        System.out.println("Invocation of Method " + methodInvocation.getMethod().getName() + " start!");
        Object proceed = methodInvocation.proceed();
        System.out.println("Invocation of Method " + methodInvocation.getMethod().getName() + " end! takes " + (System.nanoTime() - time)
                + " nanoseconds.");
        return proceed;
    }
}
