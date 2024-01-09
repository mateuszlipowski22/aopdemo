package spring.aopdemo.dao;

import spring.aopdemo.Account;

public interface AccountDAO {

    void addAccount(Account account, boolean isVipPerson);

    boolean doWork();

}
