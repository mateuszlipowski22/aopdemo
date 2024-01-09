package spring.aopdemo.dao;


import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

    @Override
    public void addAccount() {
        System.out.println(getClass() + " : DOING MY DB WORK : ADDING A MEMBERSHIP AN ACCOUNT");
    }

    @Override
    public boolean addSillyMember() {
        System.out.println(getClass() + " : DOING MY DB WORK : ADDING A SILLY MEMBERSHIP AN ACCOUNT");
        return true;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() + " : I AM GOING TO SLEEP...");
    }
}
