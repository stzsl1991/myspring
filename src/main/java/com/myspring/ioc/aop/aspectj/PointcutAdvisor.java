package com.myspring.ioc.aop.aspectj;


/**
 * 定义了获取 通知和切入点 的行为
 * Created by shulin on 16/10/25.
 */
public interface PointcutAdvisor extends Advisor {
    Pointcut2 getPointcut();
}
