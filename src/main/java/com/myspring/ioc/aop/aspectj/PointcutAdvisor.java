package com.myspring.ioc.aop.aspectj;


/**
 * Created by shulin on 16/10/25.
 */
public interface PointcutAdvisor extends Advisor {
    Pointcut getPointcut();
}
