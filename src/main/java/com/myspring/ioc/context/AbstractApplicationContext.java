package com.myspring.ioc.context;

import com.myspring.ioc.beans.BeanPostProcessor;
import com.myspring.ioc.beans.factory.AbstractBeanFactory;

import java.util.List;

/**
 * Created by shulin on 16/10/21.
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    /**
     * 重新读取Xml，将对象放入容器
     * @throws Exception
     */
    public void refresh() throws Exception{
        loadBeanDefinitions(beanFactory);
        registerBeanPostProcessors(beanFactory);
        onRefresh();
    }

    @Override
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }

    protected abstract void loadBeanDefinitions(AbstractBeanFactory beanFactory) throws Exception;

    protected void registerBeanPostProcessors(AbstractBeanFactory beanFactory) throws Exception {
        List beanPostProcessors = beanFactory.getBeansForType(BeanPostProcessor.class);
        for (Object beanPostProcessor : beanPostProcessors) {
            beanFactory.addBeanPostProcessor((BeanPostProcessor) beanPostProcessor);
        }
    }

    protected void onRefresh() throws Exception{
        beanFactory.preInstantiateSingletons();
    }
}
