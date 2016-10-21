package com.myspring.ioc.factory;

import com.myspring.ioc.bean.BeanDefinition;
import com.myspring.ioc.bean.BeanReference;
import com.myspring.ioc.bean.PropertyValue;
import com.myspring.ioc.bean.PropertyValues;

import java.lang.reflect.Field;

/**
 * 具体工厂类，相比较1.2版本，此时在创建对象的时候需要为对象注入属性
 * Created by shulin on 16/10/20.
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception{
        Object bean = this.createBeanInstance(beanDefinition);
        beanDefinition.setBean(bean);
        applyPropertyValues(bean,beanDefinition);
        return bean;
    }

    /**
     * 实例化Bean
     * @param beanDefinition
     * @return
     * @throws Exception
     */
    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception{
        return beanDefinition.getBeanClass().newInstance();
    }

    /**
     * 为bean注入属性
     * @param bean
     * @param beanDefinition
     * @throws Exception
     */
    protected void applyPropertyValues(Object bean,BeanDefinition beanDefinition) throws Exception{
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        for (PropertyValue propertyValue : propertyValues.getPropertyValues()){
            //可以获取到私有的属性
            Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference){
                BeanReference ref = (BeanReference) value;
                //从容器中取
                value = getBean(ref.getName());
            }
            declaredField.set(bean,value);
        }
    }

}
