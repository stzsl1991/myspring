package com.myspring.ioc.beans;

/**
 * 处理Bean之间的依赖，表示这个属性是对另一个Bean的引用
 * Created by shulin on 16/10/21.
 */
public class BeanReference {
    private String name;
    private Object bean;

    public BeanReference(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
