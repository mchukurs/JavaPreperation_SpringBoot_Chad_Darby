package com.chukurs.learning.services;

import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public interface NannyService {

    String findOne(int id);

    List<String> findMany(String name);

}
