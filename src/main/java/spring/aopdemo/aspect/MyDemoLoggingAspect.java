package spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("spring.aopdemo.aspect.AopExpressions.forDaoPackageExcludeGetterAndSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println(getClass() + " : \n==========>>>> Executing @Before advice an addAccount()");
    }
}
