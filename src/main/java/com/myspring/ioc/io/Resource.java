package com.myspring.ioc.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Resource是Spring内部定位资源的接口
 * Created by shulin on 16/10/20.
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
