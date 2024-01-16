package spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

//    @Before("execution(public void spring.aopdemo.dao.AccountDAO.addAccount())")
//    @Before("execution(public void add* ())")
//    @Before("execution(* add*(spring.aopdemo.Account))")
//    @Before("execution(* add*(spring.aopdemo.Account, ..))")
//    @Before("execution(* add*( .. ))")
//    @Before("execution(* spring.aopdemo.dao.*.*( .. ))")

    @Pointcut("execution(* spring.aopdemo.dao.*.*( .. ))")
    public void forDaoPackage(){};

    @Pointcut("execution(* spring.aopdemo.dao.*.get*( .. ))")
    public void getter(){};

    @Pointcut("execution(* spring.aopdemo.dao.*.set*( .. ))")
    public void setter(){};

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageExcludeGetterAndSetter(){};

}
