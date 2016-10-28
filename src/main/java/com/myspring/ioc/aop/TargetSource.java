package com.myspring.ioc.aop;

/**
 * Created by shulin on 16/10/24.
 */
public class TargetSource {
    //被代理对象接口
    private Class<?>[] interfaces;
    //被代理对象
    private Object target;
    //被代理的对象
    private Class<?> targetClass;

    public TargetSource(Object target, Class<?> targetClass,Class<?>... interfaces) {
        this.target = target;
        this.targetClass = targetClass;
        this.interfaces = interfaces;
    }

    public Class<?>[] getInterfaces() {
        return interfaces;
    }

    public Object getTarget() {
        return target;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }
}
