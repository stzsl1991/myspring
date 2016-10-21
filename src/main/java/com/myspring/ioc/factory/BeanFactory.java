package com.myspring.ioc.factory;

import com.myspring.ioc.bean.BeanDefinition;

/**
 * 工厂接口
 * Created by shulin on 16/10/20.
 */
public interface BeanFactory {
    public Object getBean(String name) throws Exception;

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;
}
