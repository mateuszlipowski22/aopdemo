package spring.aopdemo.dao;

import spring.aopdemo.Account;

import java.util.List;

public interface AccountDAO {

    void addAccount(Account account, boolean isVipPerson);

    boolean doWork();

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);

    public List<Account> findAccounts();
}
