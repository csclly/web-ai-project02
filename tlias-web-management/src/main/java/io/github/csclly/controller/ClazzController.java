package io.github.csclly.controller;


import io.github.csclly.poji.Clazz;
import io.github.csclly.poji.Result;
import io.github.csclly.service.ClazzService;
import io.github.csclly.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/clazzs")
@RestController
public class ClazzController {
    @Autowired
    private ClazzService clazzService;

    /*
    * 添加班级
    */
    @PostMapping
    public Result add(@RequestBody Clazz clazz){
        log.info("新增班级：{}",clazz);
        clazzService.add(clazz);
        return Result.success();
    }

    /*
    * 查询所有班级
    */
    @GetMapping("/list")
    public Result list(){
        log.info("查询所有班级");
        List<Clazz> clazzList= clazzService.findAll();

        return Result.success(clazzList);
    }
}
