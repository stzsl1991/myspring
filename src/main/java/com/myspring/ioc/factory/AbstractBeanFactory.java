package com.myspring.ioc.factory;

import com.myspring.ioc.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 抽象工厂类，具有存放Bean包装对象的Container
 * Created by shulin on 16/10/20.
 */
public abstract class AbstractBeanFactory implements BeanFactory{
    Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    @Override
    public Object getBean(String name) {
        if (beanDefinitionMap.containsKey(name)) {
            return beanDefinitionMap.get(name).getBean();
        }
        return null;
    }

    @Override
    public void registerBeanDefinition(String name,BeanDefinition beanDefinition) throws Exception{
        Object bean = doCreateBean(beanDefinition);
        beanDefinition.setBean(bean);
        if(!beanDefinitionMap.containsKey(name)) {
            beanDefinitionMap.put(name, beanDefinition);
        }
    }

    /**
     * tag:v1.1版本中，HelloWorldService需要通过new来进行实例化
     *
     * doCreateBean的功能就是通过反射实例化Bean，在此之前需要设置Bean的className(包.类名)
     *
     * @param beanDefinition
     * @return
     */
    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;

}
