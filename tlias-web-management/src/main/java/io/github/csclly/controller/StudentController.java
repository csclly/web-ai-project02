package io.github.csclly.controller;

import io.github.csclly.poji.PageResult;
import io.github.csclly.poji.Result;
import io.github.csclly.poji.Student;
import io.github.csclly.poji.StudentQueryParam;
import io.github.csclly.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /*
    * 学员列表数据的条件分页查询
    * */
    @GetMapping
    public Result page(StudentQueryParam studentQueryParam){
        log.info("学员列表数据的条件分页查询：{}", studentQueryParam);
        PageResult<Student> pageResult = studentService.page(studentQueryParam);

        return Result.success(pageResult);

    }

    /*
    * 添加学员
    * */
    @PostMapping
    public Result add(@RequestBody Student student){
        log.info("添加学员：{}", student);
        studentService.add(student);
        return Result.success();

    }

    /*
    * 根据ID查询学员的信息
    * */
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        log.info("根据ID查询学员的信息：{}", id);
        Student student = studentService.selectById(id);
        return Result.success(student);
    }

    /*
    * 修改学员
    * */
    @PutMapping
    public Result update(@RequestBody Student student){
        log.info("修改学员：{}", student);
        studentService.update(student);
        return Result.success();
    }

    /*
    * 删除学员
    * */
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable Integer[] ids){
        log.info("批量删除学员信息：{}",ids);
        studentService.deleteById(ids);
        return Result.success();
    }

    /*
    * 违纪处理
    * */
    @PutMapping("/violation/{id}/{score}")
    public Result updateViolation(@PathVariable Integer id, @PathVariable Integer score){
        log.info("修改学员的违纪信息：{},{}", id,score);
        studentService.updateViolation(id, score);
        return Result.success();
    }
}
