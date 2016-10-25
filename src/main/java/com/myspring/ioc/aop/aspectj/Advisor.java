package com.myspring.ioc.aop.aspectj;

import org.aopalliance.aop.Advice;

/**
 * Created by shulin on 16/10/25.
 */
public interface Advisor {
    Advice getAdvice();
}
