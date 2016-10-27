package com.myspring.ioc.aop.aspectj;

/**
 * 类的过滤，判断这个类是否需要动态代理
 * Created by shulin on 16/10/25.
 */
public interface ClassFilter {
    boolean matches(Class targetClass);
}
