package com.chukurs.learning.services.impl;

import com.chukurs.learning.services.NannyService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NannyServiceImpl implements NannyService {

    @Override
    public String findOne(int id) {
        return "Anna";
    }

    @Override
    public List<String> findMany(String name) {
        return List.of("Anna B", "Anna C");
    }
}
