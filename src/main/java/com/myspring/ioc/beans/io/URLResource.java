package com.myspring.ioc.beans.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * URL资源访问接口实现类，返回inputstream
 * Created by shulin on 16/10/20.
 */
public class URLResource implements Resource {
    private final URL url;

    public URLResource(URL url) {
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection connection = url.openConnection();
        connection.connect();
        return connection.getInputStream();
    }
}
