package com.myspring.ioc.aop.aspectj;

import com.myspring.ioc.beans.factory.BeanFactory;

/**
 * Created by shulin on 16/10/26.
 */
public interface BeanFactoryAware {
    void setBeanFactory(BeanFactory beanFactory) throws Exception;
}
