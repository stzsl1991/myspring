package com.myspring.ioc.bean;

/**
 * 用于Bean属性的注入
 * Created by shulin on 16/10/20.
 */
public class PropertyValue {
    private String name;
    private Object value;

    public PropertyValue() {
    }

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
