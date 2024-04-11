package com.chukurs.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
    @Override
    public void addAccount() {
        System.out.println("Database is adding some accounts!");
    }
}
