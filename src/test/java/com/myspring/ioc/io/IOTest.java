package com.myspring.ioc.io;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by shulin on 16/10/20.
 */
public class IOTest {
    @Test
    public void test() throws IOException{
        ResourceLoader resourceLoader = new ResourceLoader();
        Resource resource = resourceLoader.getResource("myspring.xml");
        InputStream inputStream = resource.getInputStream();
        Assert.assertNotNull(inputStream);

    }

}

