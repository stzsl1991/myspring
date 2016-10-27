package com.myspring.ioc.aop.aspectj;

import com.myspring.ioc.aop.AdvisedSupport;
import com.myspring.ioc.aop.JdkDynamicAopProxy;
import com.myspring.ioc.aop.TargetSource;
import com.myspring.ioc.beans.BeanPostProcessor;
import com.myspring.ioc.beans.factory.AbstractBeanFactory;
import com.myspring.ioc.beans.factory.BeanFactory;
import org.aopalliance.intercept.MethodInterceptor;

import java.util.List;

/**
 * Created by shulin on 16/10/26.
 */
public class AspectJAwareAdvisorAutoProxyCreator implements BeanPostProcessor, BeanFactoryAware {
    private AbstractBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws Exception {
        this.beanFactory = (AbstractBeanFactory) beanFactory;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        if (bean instanceof AspectJExpressionPointcutAdvisor) {
            return bean;
        }
        if (bean instanceof MethodInterceptor) {
            return bean;
        }
        List<AspectJExpressionPointcutAdvisor> advisors = beanFactory
                .getBeansForType(AspectJExpressionPointcutAdvisor.class);
        for (AspectJExpressionPointcutAdvisor advisor : advisors) {
            if (advisor.getPointcut().getClassFilter().matches(bean.getClass())) {
                AdvisedSupport advisedSupport = new AdvisedSupport();
                advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
                advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
                TargetSource targetSource = new TargetSource(bean, bean.getClass().getInterfaces());
                advisedSupport.setTargetSource(targetSource);
                //返回代理对象
                return new JdkDynamicAopProxy(advisedSupport).getProxy();
            }
        }
        return bean;
    }
}
