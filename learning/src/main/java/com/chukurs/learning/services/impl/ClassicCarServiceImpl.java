package com.chukurs.learning.services.impl;

import com.chukurs.learning.services.CarService;
import org.springframework.stereotype.Service;

@Service
public class ClassicCarServiceImpl implements CarService {
    @Override
    public String drive() {
        return "Drive classic car";
    }
}
