package com.myspring.ioc.context;

import com.myspring.ioc.beans.BeanDefinition;
import com.myspring.ioc.beans.factory.AbstractBeanFactory;
import com.myspring.ioc.beans.factory.AutowireCapableBeanFactory;
import com.myspring.ioc.beans.io.ResourceLoader;
import com.myspring.ioc.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * Created by shulin on 16/10/21.
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {
    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation) throws Exception{
        this(configLocation, new AutowireCapableBeanFactory());
    }

    public ClassPathXmlApplicationContext(String configLocation,AbstractBeanFactory beanFactory) throws Exception{
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();
    }

    @Override
    public void refresh() throws Exception{
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
        for (Map.Entry<String,BeanDefinition> entry : xmlBeanDefinitionReader.getRegistry().entrySet()){
            beanFactory.registerBeanDefinition(entry.getKey(),entry.getValue());
        }
    }
}
