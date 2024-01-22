package spring.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import spring.aopdemo.Account;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("spring.aopdemo.aspect.AopExpressions.forDaoPackageExcludeGetterAndSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println(getClass() + " : \n==========>>>> Executing @Before advice an addAccount()");

        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method : " + methodSignature);

        Object[] args = theJoinPoint.getArgs();

        for (Object tempArg : args) {
            System.out.println(tempArg);

            if (tempArg instanceof Account) {
                Account account = (Account) tempArg;
                System.out.println("account name : " + account.getName());
                System.out.println("account level : " + account.getLevel());
            }
        }
    }

    @AfterReturning(
            pointcut = "execution(* spring.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

        String method = joinPoint.getSignature().getName();

        System.out.println("\n======> : " + method);
        System.out.println(result);
        convertAccountNamesToUpperCase(result);
        System.out.println(result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        result.forEach(account -> account.setName(account.getName().toUpperCase()));
    }

    @AfterThrowing(
            pointcut = "execution(* spring.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exception"
    )
    public void afterThrowingFindAccounts(JoinPoint joinPoint, Throwable exception) {
        String method = joinPoint.getSignature().getName();
        System.out.println(getClass() + " : \n==========>>>> Executing @AfterThrowing advice " + method);
        System.out.println("\n======> The exception is : " + exception);
    }

    @After("execution(* spring.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        System.out.println(getClass() + " : \n==========>>>> Executing @After (finally) advice " + method);
    }
}
