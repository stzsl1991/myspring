package com.myspring.ioc.aop;

import com.myspring.ioc.HelloWorldService;
import com.myspring.ioc.HelloWorldServiceImpl;
import com.myspring.ioc.aop.aspectj.AspectJExpressionPointcut;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by shulin on 16/10/25.
 */
public class AspectJExpressionPointcutTest {

    @Test
    public void testClassFilter() throws Exception {
        String expression = "execution(* com.myspring.ioc.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getClassFilter().matches(HelloWorldService.class);
        Assert.assertTrue(matches);
    }

    @Test
    public void testMethodInterceptor() throws Exception {
        String expression = "execution(* com.myspring.ioc.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getMethodMatcher().matches(HelloWorldServiceImpl.class.getDeclaredMethod("sayHello"),HelloWorldServiceImpl.class);
        Assert.assertTrue(matches);
    }
}
