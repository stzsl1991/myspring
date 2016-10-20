package com.myspring.ioc.bean;

/**
 * 用来封装Bean对象，除此之外可以封装一些额外的元数据
 * Created by shulin on 16/10/20.
 */
public class BeanDefinition {
    //实体对象
    private Object bean;
    //对象的类信息
    private Class beanClass;
    //这里的类名必须是“包名.类名”
    private String beanClassName;
    //对象的属性信息存放容器，需要实例化
    private PropertyValues propertyValues = new PropertyValues();

    public BeanDefinition() {
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
    public String getBeanClassName() {
        return beanClassName;
    }
    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try {
            //加载Bean类对象
            this.beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
