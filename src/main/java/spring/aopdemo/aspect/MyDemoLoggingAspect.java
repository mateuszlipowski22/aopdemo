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
    private void beforeAnyDao(){};

    @Before("beforeAnyDao()")
    public void beforeAddAccountAdvice(){
        System.out.println(getClass() + " : \n==========>>>> Executing @Before advice an addAccount()");
    }
}
