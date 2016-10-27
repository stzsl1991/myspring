package com.myspring.ioc.beans;

/**
 * Created by shulin on 16/10/26.
 */
public interface BeanPostProcessor {
    /**
     * Bean初始化之前
     *
     * @param bean
     * @param beanName
     * @return
     * @throws Exception
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception;

    /**
     * Bean初始化之后
     *
     * @param bean
     * @param beanName
     * @return
     * @throws Exception
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws Exception;
}
