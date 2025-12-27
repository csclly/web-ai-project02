package io.github.csclly.service.impl;

import io.github.csclly.mapper.EmpMapper;
import io.github.csclly.poji.Emp;
import io.github.csclly.poji.PageResult;
import io.github.csclly.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageResult<Emp> page(Integer page, Integer pagesize) {
        Long total = empMapper.count();

        Integer start = (page-1)*pagesize;
        List<Emp> rows = empMapper.list(start, pagesize);

        return new PageResult<Emp>(total, rows);
    }
}
