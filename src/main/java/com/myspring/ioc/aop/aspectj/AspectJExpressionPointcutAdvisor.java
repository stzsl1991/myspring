package com.myspring.ioc.aop.aspectj;

import org.aopalliance.aop.Advice;

/**
 * Created by shulin on 16/10/25.
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    private AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();

    private Advice advice;

    public void setAdvice(Advice advice){
        this.advice = advice;
    }

    public void setExpression(String expression){
        pointcut.setExpression(expression);
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
