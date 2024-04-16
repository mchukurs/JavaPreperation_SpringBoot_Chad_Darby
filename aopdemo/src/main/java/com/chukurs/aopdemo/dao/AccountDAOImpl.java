package com.chukurs.aopdemo.dao;

import com.chukurs.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {
    private String name;
    private String serviceCode;

    @Override
    public void addAccount(Account theAccount, boolean vip) {
        System.out.println("Database is adding " + theAccount.getName());
    }

    @Override
    public boolean doWork() {
        System.out.println("Doing some work");
        return true;
    }

    public String getName() {
        System.out.println("inside getName account");
        return name;
    }

    public void setName(String name) {
        System.out.println("inside setName account");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println("inside getServiceCode account");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println("inside setServiceCode account");
        this.serviceCode = serviceCode;
    }

    @Override
    public List<Account> findAccounts() {
        //mimic fake account retrieval
        List<Account> myAccounts = new ArrayList<Account>();
        myAccounts.add(new Account("John", "Silver"));
        myAccounts.add(new Account("Madhu", "Platinum"));
        myAccounts.add(new Account("matiss", "Gold"));
        return myAccounts;
    }
}
