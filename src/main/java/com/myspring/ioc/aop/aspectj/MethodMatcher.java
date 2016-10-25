package com.myspring.ioc.aop.aspectj;

import java.lang.reflect.Method;

/**
 * Created by shulin on 16/10/25.
 */
public interface MethodMatcher {
    boolean matches(Method method, Class targetClass);
}
