package com.myspring.ioc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Bean容器
 * Created by shulin on 16/10/20.
 */
public class BeanFactory {
    Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    public Object getBean(String name) {
        if (beanDefinitionMap.containsKey(name)) {
            return beanDefinitionMap.get(name).getBean();
        }
        return null;
    }

    public void registerBeanDefinition(String name,BeanDefinition beanDefinition){
        if(!beanDefinitionMap.containsKey(name)) {
            beanDefinitionMap.put(name, beanDefinition);
        }
    }

}
