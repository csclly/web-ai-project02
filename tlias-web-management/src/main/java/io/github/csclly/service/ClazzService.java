package io.github.csclly.service;

import io.github.csclly.poji.Clazz;

import java.util.List;

public interface ClazzService {



    void add(Clazz clazz);

    List<Clazz> findAll();
}
