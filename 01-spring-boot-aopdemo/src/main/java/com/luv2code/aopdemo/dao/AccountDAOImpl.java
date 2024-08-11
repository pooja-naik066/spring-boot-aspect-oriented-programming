package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;

    private String serviceCode;

    @Override
    public List<Account> findAccounts() {
        return  findAccounts(false);

    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        System.out.println("In method findAccounts---created today");

        //simulate an exception
        if(tripWire){
            throw new RuntimeException("Exception thrown");

        }

        List<Account> accounts=new ArrayList<>();
        //create sample accounts and add to account list
        Account account1=new Account("Sheldon","Gold");
        Account account2=new Account("Leonard","Silver");
        Account account3=new Account("Amy","Fowler");

        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);

        return accounts;
    }

    @Override
    public void addAccount(Account account,boolean vipFlag) {
        System.out.println(getClass()+": DOING MY DB WORK: ADDING AN ACCOUNT");

    }

    @Override
    public boolean doWork() {
        System.out.println(getClass()+": doWork()");
        return false;
    }

    public String getName() {
        System.out.println(getClass()+": getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+": setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass()+": getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+": setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
