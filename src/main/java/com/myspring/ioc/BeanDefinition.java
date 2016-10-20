package com.myspring.ioc;

/**
 * 用来封装Bean对象，除此之外可以封装一些额外的元数据
 * Created by shulin on 16/10/20.
 */
public class BeanDefinition {
    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }

}
