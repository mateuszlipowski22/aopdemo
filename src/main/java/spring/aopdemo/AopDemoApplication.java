package spring.aopdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.context.annotation.Bean;
import spring.aopdemo.dao.AccountDAO;
import spring.aopdemo.dao.MembershipDAO;
import spring.aopdemo.service.TrafficFortuneService;

import java.util.List;

@SpringBootApplication(exclude = JmxAutoConfiguration.class)
public class AopDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO,
                                               MembershipDAO membershipDAO,
                                               TrafficFortuneService trafficFortuneService) {
        return runner -> {

//			demoTheBeforeAdvice(accountDAO,membershipDAO);
//            demoTheAfterReturningAdvice(accountDAO);
//            demoTheAfterThrowingAdvice(accountDAO);
//            demoTheAfterAdvice(accountDAO);
            demoTheAroundAdvice(trafficFortuneService);

        };
    }

    private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {
        System.out.println("\nMain program : demoTheAroundAdvice");
        System.out.println("Calling getFortune()");
        String data = trafficFortuneService.getFortune();
        System.out.println("\nMy fortune is : " + data);
        System.out.println("Finished");
    }

    private void demoTheAfterAdvice(AccountDAO accountDAO) {
        List<Account> accounts = null;
        try {
            boolean tripWire = false;
            accounts = accountDAO.findAccounts(tripWire);
        } catch (Exception e) {
            System.out.println("\n\nMain program : ... caught the excpetion " + e);
        }

        System.out.println("\n\nMain program : demoTheAfterReturningAdvice");
        System.out.println("-".repeat(20));

        for (Account account : accounts) {
            System.out.println(account);
            System.out.println("-".repeat(20));
        }

        System.out.println("\n");
    }

    private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
        List<Account> accounts = null;
        try {
            boolean tripWire = true;
            accounts = accountDAO.findAccounts(tripWire);
        } catch (Exception e) {
            System.out.println("\n\nMain program : ... caught the excpetion " + e);
        }

        System.out.println("\n\nMain program : demoTheAfterReturningAdvice");
        System.out.println("-".repeat(20));

        for (Account account : accounts) {
            System.out.println(account);
            System.out.println("-".repeat(20));
        }

        System.out.println("\n");
    }

    private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {

        List<Account> accounts = accountDAO.findAccounts();

        System.out.println("\n\nMain program : demoTheAfterReturningAdvice");
        System.out.println("-".repeat(20));

        for (Account account : accounts) {
            System.out.println(account);
            System.out.println("-".repeat(20));
        }

        System.out.println("\n");
    }

    private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
        Account account = new Account("Joe", "Proficient");
        accountDAO.addAccount(account, true);

        membershipDAO.addAccount();

        membershipDAO.addSillyMember();

        membershipDAO.goToSleep();

        accountDAO.doWork();

        accountDAO.setName("foobar");
        accountDAO.setServiceCode("silver");

        String name = accountDAO.getName();
        String serviceCode = accountDAO.getServiceCode();

    }
}
