package com.myspring.ioc.aop.aspectj;

import org.aopalliance.aop.Advice;

/**
 * 通知者，获取通知，通知定义了切面要发生的时间和故事
 * Created by shulin on 16/10/25.
 */
public interface Advisor {
    Advice getAdvice();
}
