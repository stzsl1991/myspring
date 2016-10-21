package com.myspring.ioc.beans.factory;

import com.myspring.ioc.beans.BeanDefinition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 抽象工厂类，具有存放Bean包装对象的Container
 * Created by shulin on 16/10/20.
 */
public abstract class AbstractBeanFactory implements BeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    private final List<String> beanDefinitionNames = new ArrayList<String>();


    @Override
    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (null == beanDefinition) {
            throw new IllegalArgumentException("No bean named " + name + " is defined");
        }
        Object bean = beanDefinition.getBean();
        if (null == bean) {
            bean = doCreateBean(beanDefinition);
        }
        return bean;
    }

    /**
     * 注册Bean的时候，除了像容器中加入Bean之外，还将BeanName保存
     * @param name
     * @param beanDefinition
     * @throws Exception
     */
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
        if (!beanDefinitionMap.containsKey(name)) {
            beanDefinitionMap.put(name, beanDefinition);
            beanDefinitionNames.add(name);
        }
    }


    /**
     * 采用饿汉的单例模式，先实例化
     *
     * @throws Exception
     */
    public void preInstantiateSingletons() throws Exception {
        for (Iterator it = beanDefinitionNames.iterator();it.hasNext();){
            String beanName = (String)it.next();
            getBean(beanName);
        }
    }

    /**
     * tag:v1.1版本中，HelloWorldService需要通过new来进行实例化
     * <p/>
     * doCreateBean的功能就是通过反射实例化Bean，在此之前需要设置Bean的className(包.类名)
     *
     * @param beanDefinition
     * @return
     */
    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;

}
