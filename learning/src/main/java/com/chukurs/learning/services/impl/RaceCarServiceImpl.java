package com.chukurs.learning.services.impl;

import com.chukurs.learning.services.CarService;

public class RaceCarServiceImpl implements CarService {
    public RaceCarServiceImpl() {
        System.out.println("race car constructor");
    }

    @Override
    public String drive() {
        return "Drive race car ";
    }
}
