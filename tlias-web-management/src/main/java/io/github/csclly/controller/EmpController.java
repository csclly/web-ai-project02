package io.github.csclly.controller;

import io.github.csclly.poji.Emp;
import io.github.csclly.poji.PageResult;
import io.github.csclly.poji.Result;
import io.github.csclly.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pagesize){
        log.info("分页查询：{},{}", page,pagesize);
        PageResult<Emp> pageResult = empService.page(page, pagesize);
        return Result.success(pageResult);
    }
}
