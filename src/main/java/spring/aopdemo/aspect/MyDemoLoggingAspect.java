package spring.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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

        for(Object tempArg : args){
            System.out.println(tempArg);

            if(tempArg instanceof Account){
                Account account = (Account) tempArg;
                System.out.println("account name : "+account.getName());
                System.out.println("account level : "+account.getLevel());
            }
        }
    }

    @AfterReturning(
            pointcut = "execution(* spring.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){
        String method = joinPoint.getSignature().getName();
        System.out.println("\n======> : " +method);
    }
}
