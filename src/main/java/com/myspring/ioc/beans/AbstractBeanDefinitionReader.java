package com.myspring.ioc.beans;

import com.myspring.ioc.beans.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * 抽象BeanDefinition解析类，定义了数据存储结构
 * Created by shulin on 16/10/20.
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    private Map<String, BeanDefinition> registry;
    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        registry = new HashMap<String, BeanDefinition>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
