package com.chukurs.aopdemo.dao;

import com.chukurs.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
    @Override
    public void addAccount(Account theAccount,boolean vip) {
        System.out.println("Database is adding " + theAccount.getName());
    }
}
