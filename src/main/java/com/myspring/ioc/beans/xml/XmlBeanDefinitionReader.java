package com.myspring.ioc.beans.xml;

import com.myspring.ioc.beans.AbstractBeanDefinitionReader;
import com.myspring.ioc.beans.BeanDefinition;
import com.myspring.ioc.beans.BeanReference;
import com.myspring.ioc.beans.PropertyValue;
import com.myspring.ioc.beans.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * Created by shulin on 16/10/20.
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {


    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(String location) throws Exception {
        InputStream inputStream = getResourceLoader().getResource(location).getInputStream();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(inputStream);
        //获取根节点
        Element root = doc.getDocumentElement();
        //获取根节点下的子节点，并且遍历所有节点
        NodeList nodeList = root.getChildNodes();
        int size = nodeList.getLength();
        Node node;
        for (int i = 0; i < size; i++) {
            node = nodeList.item(i);
            if (node instanceof Element){
                Element element = (Element) node;
                //解析成BeanDefinition
                processBeanDefinition(element);
            }
        }
        inputStream.close();
    }

    /**
     * 解析成BeanDefinition
     * @param element
     */
    protected void processBeanDefinition(Element element){
        String beanName = element.getAttribute("id");
        String beanClassName = element.getAttribute("class");
        BeanDefinition beanDefinition = new BeanDefinition();
        processProperty(element,beanDefinition);
        beanDefinition.setBeanClassName(beanClassName);
        getRegistry().put(beanName,beanDefinition);
    }

    /**
     * 注入属性
     * @param element
     * @param beanDefinition
     */
    protected void processProperty(Element element,BeanDefinition beanDefinition){
        NodeList nodeList = element.getElementsByTagName("property");
        int size = nodeList.getLength();
        Node node;
        for (int i = 0; i < size; i++) {
            node = nodeList.item(i);
            if (node instanceof Element){
                Element el = (Element) node;
                String name = el.getAttribute("name");
                String value = el.getAttribute("value");
                if(value!=null && value.length()>0){
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name,value));
                }else{
                    String rel = el.getAttribute("ref");
                    if (rel==null || rel.length()==0){
                        throw new IllegalArgumentException("Configuration problem: <property> element for property '"
                                + name + "' must specify a ref or value");
                    }
                    BeanReference beanReference = new BeanReference(rel);
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name,beanReference));
                }
            }
        }
    }
}
