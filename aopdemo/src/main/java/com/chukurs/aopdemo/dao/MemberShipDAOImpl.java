package com.chukurs.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MemberShipDAOImpl implements MemberShipDAO {

    @Override
    public void addAccount() {
        System.out.println("Database is adding some memberships!");
    }
}
