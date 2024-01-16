package spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

    @Before("spring.aopdemo.aspect.AopExpressions.forDaoPackageExcludeGetterAndSetter()")
    public void logToCloudAsync(){
        System.out.println(getClass() + " : \n==========>>>> Logging to Cloud in async fashion");
    }
}
