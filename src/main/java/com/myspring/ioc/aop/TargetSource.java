package com.myspring.ioc.aop;

/**
 * Created by shulin on 16/10/24.
 */
public class TargetSource {
    //被代理对象接口的Class
    private Class targetClass;
    //被代理对象
    private Object target;

    public TargetSource(Class<?> targetClass, Object target) {
        this.targetClass = targetClass;
        this.target = target;
    }

    public Class getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(Class targetClass) {
        this.targetClass = targetClass;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }
}
