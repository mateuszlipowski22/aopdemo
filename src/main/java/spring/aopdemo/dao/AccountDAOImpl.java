package spring.aopdemo.dao;


import org.springframework.stereotype.Repository;
import spring.aopdemo.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount(Account account, boolean isVipPerson) {
        System.out.println(getClass() + " : DOING MY DB WORK : ADDING AN ACCOUNT");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + " : doing work");
        return false;
    }
}
