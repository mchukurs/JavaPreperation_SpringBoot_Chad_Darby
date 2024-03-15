package com.chukurs.learning.services.impl;

import com.chukurs.learning.services.CarService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service

public class SuperCarServiceImpl implements CarService {
    @Override
    public String drive() {
        return "Drive super car (its qualifier, so higher priority)";
    }
}
