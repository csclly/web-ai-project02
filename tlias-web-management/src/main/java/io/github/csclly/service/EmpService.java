package io.github.csclly.service;

import io.github.csclly.poji.Emp;
import io.github.csclly.poji.EmpQueryParam;
import io.github.csclly.poji.PageResult;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    void save(Emp emp);

    void delete(List<Integer> ids);


    Emp getInfo(Integer id);

    void update(Emp emp);
}
