package com.myspring.ioc.beans.factory;

import com.myspring.ioc.aop.aspectj.BeanFactoryAware;
import com.myspring.ioc.beans.BeanDefinition;
import com.myspring.ioc.beans.BeanReference;
import com.myspring.ioc.beans.PropertyValue;
import com.myspring.ioc.beans.PropertyValues;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 具体工厂类，相比较1.2版本，此时在创建对象的时候需要为对象注入属性
 * Created by shulin on 16/10/20.
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    /**
     * 为bean注入属性
     *
     * @param bean
     * @param beanDefinition
     * @throws Exception
     */
    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
        if (bean instanceof BeanFactoryAware) {
            ((BeanFactoryAware) bean).setBeanFactory(this);
        }
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {

            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = super.getBean(beanReference.getName());
            }
            try {
                Method declaredMethod = bean.getClass().getDeclaredMethod(
                        getSetterMethod(propertyValue.getName()), value.getClass());
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(bean, value);
            } catch (NoSuchMethodException e) {
                Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
                declaredField.setAccessible(true);
                declaredField.set(bean, value);
            }

        }
    }

    /**
     * 通过属性获取setter方法
     *
     * @param attr
     * @return
     */
    private String getSetterMethod(String attr) {
        return "set" + attr.substring(0, 1).toUpperCase() + attr.substring(1);
    }

}
