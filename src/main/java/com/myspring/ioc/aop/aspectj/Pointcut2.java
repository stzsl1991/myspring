package com.myspring.ioc.aop.aspectj;

/**
 * 切入点，定义了故事发生的地点，在哪里切入
 * Created by shulin on 16/10/25.
 */
public interface Pointcut2 {
    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}