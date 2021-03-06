package com.myspring.ioc.aop;

import com.myspring.ioc.aop.aspectj.MethodMatcher;
import org.aopalliance.intercept.MethodInterceptor;

/**
 * 代理相关的元数据
 * Created by shulin on 16/10/24.
 */
public class AdvisedSupport {
    //被代理对象
    private TargetSource targetSource;
    //方法拦截器
    private MethodInterceptor methodInterceptor;

    private MethodMatcher methodMatcher;

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }

    public MethodMatcher getMethodMatcher() {
        return methodMatcher;
    }

    public void setMethodMatcher(MethodMatcher methodMatcher) {
        this.methodMatcher = methodMatcher;
    }
}
