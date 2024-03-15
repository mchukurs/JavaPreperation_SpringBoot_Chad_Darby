package com.chukurs.learning.services.impl;

import com.chukurs.learning.services.CarService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Primary
//@Lazy
@Component
@Scope (ConfigurableBeanFactory.SCOPE_PROTOTYPE)//creates 1 obj per injection point
public class ClassicCarServiceImpl implements CarService {
    public ClassicCarServiceImpl(){
        System.out.println("classic car constructor");
    }
    @Override
    public String drive() {
        return "Drive classic car (its primary)";
    }
}
