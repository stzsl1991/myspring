package com.myspring.ioc.bean;

/**
 * 从配置中读取BeanDefinition
 * Created by shulin on 16/10/20.
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(String location) throws Exception;
}
