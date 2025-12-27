package io.github.csclly.service;

import io.github.csclly.poji.Emp;
import io.github.csclly.poji.PageResult;

public interface EmpService {
    PageResult<Emp> page(Integer page, Integer pagesize);
}
