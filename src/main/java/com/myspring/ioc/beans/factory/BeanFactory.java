package com.myspring.ioc.beans.factory;

/**
 * 工厂接口
 * Created by shulin on 16/10/20.
 */
public interface BeanFactory {
    Object getBean(String name) throws Exception;
}
