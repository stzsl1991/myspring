package com.myspring.ioc.aop.aspectj;

/**
 * Created by shulin on 16/10/25.
 */
public interface ClassFilter {
    boolean matches(Class targetClass);
}
