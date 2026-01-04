package io.github.csclly.controller;

import io.github.csclly.poji.Emp;
import io.github.csclly.poji.EmpQueryParam;
import io.github.csclly.poji.PageResult;
import io.github.csclly.poji.Result;
import io.github.csclly.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping
    public Result page(EmpQueryParam empQueryParam){
        log.info("分页查询：{}", empQueryParam);
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }


    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("新增员工：{}", emp);
        empService.save(emp);
        return Result.success();
    }

    @DeleteMapping
//    public Result delete(Integer[] ids){
//            log.info("删除员工：{}", ids.toString);
//        empService.delete(ids);
//
//        return Result.success();
//}
    public Result delete(@RequestParam List<Integer> ids){
        log.info("根据id批量删除员工：{}", ids);
        empService.delete(ids);

        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据ID查询员工：{}", id);
        Emp emp = empService.getInfo(id);
        return Result.success(emp);
    }
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("修改员工：{}", emp);
        empService.update(emp);
        return Result.success();
    }

    @GetMapping("/list")
    public Result findAll(){
        log.info("查询全部员工信息");
        List<Emp> empList = empService.findAll();
        return Result.success(empList);
    }

}
