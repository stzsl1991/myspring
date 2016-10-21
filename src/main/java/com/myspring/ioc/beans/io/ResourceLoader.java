package com.myspring.ioc.beans.io;

import java.net.URL;

/**
 * 资源加载器，返回具体资源实现类的对象
 * Created by shulin on 16/10/20.
 */
public class ResourceLoader {
    public Resource getResource(String location) {
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new URLResource(resource);
    }
}
