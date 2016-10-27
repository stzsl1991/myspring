package com.myspring.ioc.aop.aspectj;

import org.aopalliance.aop.Advice;

/**
 * 切入点和通知 构成  切面
 * Created by shulin on 16/10/25.
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {
    //切入点
    private AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
    //通知
    private Advice advice;

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public void setExpression(String expression) {
        this.pointcut.setExpression(expression);
    }

    @Override
    public Pointcut getPointcut() {
        return this.pointcut;
    }

    @Override
    public Advice getAdvice() {
        return this.advice;
    }
}
