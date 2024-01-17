package spring.aopdemo.dao;


import org.springframework.stereotype.Repository;
import spring.aopdemo.Account;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;
    private String serviceCode;

    @Override
    public void addAccount(Account account, boolean isVipPerson) {
        System.out.println(getClass() + " : DOING MY DB WORK : ADDING AN ACCOUNT");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + " : doing work");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + " : getName");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " : setName");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + " : getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " : setServiceCode()");
        this.serviceCode = serviceCode;
    }

    @Override
    public List<Account> findAccounts() {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("John","Silver"));
        accounts.add(new Account("Mady","Platinum"));
        accounts.add(new Account("Luca","Gold"));
        return accounts;
    }
}
