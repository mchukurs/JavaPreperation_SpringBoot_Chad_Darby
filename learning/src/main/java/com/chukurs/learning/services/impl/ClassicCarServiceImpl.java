package com.chukurs.learning.services.impl;

import com.chukurs.learning.services.CarService;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
@Primary
//@Lazy
@Service
public class ClassicCarServiceImpl implements CarService {
    public ClassicCarServiceImpl(){
        System.out.println("classic car constructor");
    }
    @Override
    public String drive() {
        return "Drive classic car (its primary)";
    }
}
