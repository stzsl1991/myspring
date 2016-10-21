package com.myspring.ioc.context;

import com.myspring.ioc.beans.factory.AbstractBeanFactory;

/**
 * Created by shulin on 16/10/21.
 */
public class AbstractApplicationContext implements ApplicationContext {

    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    /**
     * 重新读取Xml，将对象放入容器
     * @throws Exception
     */
    public void refresh() throws Exception{};

    @Override
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }
}
