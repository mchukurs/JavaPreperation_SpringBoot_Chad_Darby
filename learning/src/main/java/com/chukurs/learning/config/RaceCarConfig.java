package com.chukurs.learning.config;

import com.chukurs.learning.services.CarService;
import com.chukurs.learning.services.impl.RaceCarServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Configuration
public class RaceCarConfig {

    private RaceCarServiceImpl raceCarService;

    @Bean("customBeanId")
    public CarService anyNameUWish() {
        return new RaceCarServiceImpl();
    }
}
