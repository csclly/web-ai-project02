package io.github.csclly.service;

import io.github.csclly.poji.Clazz;
import io.github.csclly.poji.ClazzQueryParam;
import io.github.csclly.poji.PageResult;

import java.util.List;

public interface ClazzService {



    void add(Clazz clazz);

    List<Clazz> findAll();

    PageResult<Clazz> page(ClazzQueryParam clazzQueryParam);

    Clazz selectById(Integer id);

    void update(Clazz clazz);

    void delete(Integer id);
}
