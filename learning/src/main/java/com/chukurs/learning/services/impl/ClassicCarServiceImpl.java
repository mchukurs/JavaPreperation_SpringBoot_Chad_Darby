package com.chukurs.learning.services.impl;

import com.chukurs.learning.services.CarService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
@Primary
@Service
public class ClassicCarServiceImpl implements CarService {
    @Override
    public String drive() {
        return "Drive classic car (its primary)";
    }
}
