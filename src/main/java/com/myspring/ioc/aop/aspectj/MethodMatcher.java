package com.myspring.ioc.aop.aspectj;

import java.lang.reflect.Method;

/**
 * 判断这个方法是否需要动态代理
 * Created by shulin on 16/10/25.
 */
public interface MethodMatcher {
    boolean matches(Method method, Class targetClass);
}
