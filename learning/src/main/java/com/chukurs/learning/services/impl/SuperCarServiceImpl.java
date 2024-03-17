package com.chukurs.learning.services.impl;

import com.chukurs.learning.services.CarService;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)//creates 1 obj per injection point
@Lazy //redundant as prototype by default is Lazy
public class SuperCarServiceImpl implements CarService {
    @PreDestroy
    public void afterBean(){
        System.out.println("before killing SuperCarServiceImpl");
    }
    public SuperCarServiceImpl(){
        System.out.println("super car constructor");
    }
    @Override
    public String drive() {
        return "Drive super car (its qualifier, so higher priority)";
    }
}
