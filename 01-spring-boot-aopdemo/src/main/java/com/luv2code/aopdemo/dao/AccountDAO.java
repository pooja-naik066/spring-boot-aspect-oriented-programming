package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.context.annotation.Lazy;

import java.util.List;

public interface AccountDAO {

    List<Account> findAccounts();

    List<Account> findAccounts(boolean tripWire);

    void addAccount(Account account,boolean vipFlag);

    boolean doWork();

    public String getName();

    public void setName(String name) ;

    public String getServiceCode() ;

    public void setServiceCode(String serviceCode) ;


}
