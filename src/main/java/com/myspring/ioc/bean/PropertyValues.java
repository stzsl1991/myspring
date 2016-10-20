package com.myspring.ioc.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 包装一个对象的所有属性
 *
 * Created by shulin on 16/10/20.
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValues = new ArrayList<PropertyValue>();

    public PropertyValues(){}

    public void addPropertyValue(PropertyValue propertyValue){
        this.propertyValues.add(propertyValue);
    }

    public List<PropertyValue> getPropertyValues(){
        return this.propertyValues;
    }
}
