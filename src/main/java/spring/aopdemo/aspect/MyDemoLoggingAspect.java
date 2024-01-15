package spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

//    @Before("execution(public void spring.aopdemo.dao.AccountDAO.addAccount())")
//    @Before("execution(public void add* ())")
//    @Before("execution(* add*(spring.aopdemo.Account))")
//    @Before("execution(* add*(spring.aopdemo.Account, ..))")
//    @Before("execution(* add*( .. ))")
//    @Before("execution(* spring.aopdemo.dao.*.*( .. ))")

    @Pointcut("execution(* spring.aopdemo.dao.*.*( .. ))")
    private void forDaoPackage(){};

    @Pointcut("execution(* spring.aopdemo.dao.*.get*( .. ))")
    private void getter(){};

    @Pointcut("execution(* spring.aopdemo.dao.*.set*( .. ))")
    private void setter(){};

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageExcludeGetterAndSetter(){};

    @Before("forDaoPackageExcludeGetterAndSetter()")
    public void beforeAddAccountAdvice(){
        System.out.println(getClass() + " : \n==========>>>> Executing @Before advice an addAccount()");
    }

    @Before("forDaoPackageExcludeGetterAndSetter()")
    public void performApiAnalytics(){
        System.out.println(getClass() + " : \n==========>>>> Performing API analytics");
    }
}
