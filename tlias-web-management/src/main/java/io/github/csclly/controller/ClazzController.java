package io.github.csclly.controller;


import io.github.csclly.poji.*;
import io.github.csclly.service.ClazzService;
import io.github.csclly.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequestMapping("/clazzs")
@RestController
public class ClazzController {
    @Autowired
    private ClazzService clazzService;

    /*
    * 班级列表查询
    * */

    @GetMapping
    public Result pageSelect(ClazzQueryParam clazzQueryParam){
        log.info("分页查询：{}", clazzQueryParam);
        PageResult<Clazz> pageResult = clazzService.page(clazzQueryParam);
        return Result.success(pageResult);
    }

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
    /*
    * 根据ID查询班级的信息
    * */
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        log.info("根据主键ID查询班级的信息");
        Clazz clazz = clazzService.selectById(id);
        return Result.success(clazz);
    }

    /*
    * 修改班级
    * */
    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        log.info("更新班级：{}", clazz);
        clazzService.update(clazz);
        return Result.success();
    }

    /*
    * 删除班级
    * */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("删除班级：", id);
        clazzService.delete(id);
        return Result.success();

    }
}
