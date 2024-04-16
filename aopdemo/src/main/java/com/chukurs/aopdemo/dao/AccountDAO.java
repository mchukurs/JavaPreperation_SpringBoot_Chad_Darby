package com.chukurs.aopdemo.dao;

import com.chukurs.aopdemo.Account;

import java.util.List;

public interface AccountDAO {
    void addAccount(Account theAccount, boolean vip);

    boolean doWork();

    public String getName();

    public void setName(String name);

    public String getServiceCode();


    void setServiceCode(String serviceCode);

    List<Account> findAccounts();
}
