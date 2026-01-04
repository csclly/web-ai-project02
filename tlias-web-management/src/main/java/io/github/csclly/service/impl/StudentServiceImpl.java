package io.github.csclly.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.github.csclly.mapper.StudentMapper;
import io.github.csclly.poji.PageResult;
import io.github.csclly.poji.Student;
import io.github.csclly.poji.StudentQueryParam;
import io.github.csclly.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult<Student> page(StudentQueryParam studentQueryParam) {
        PageHelper.startPage(studentQueryParam.getPage(), studentQueryParam.getPageSize());

        List<Student> studentList = studentMapper.list(studentQueryParam);

        Page<Student> p = (Page<Student>) studentList;

        return new PageResult<Student>(p.getTotal(), p.getResult());
    }

    @Override
    public void add(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        student.setViolationCount((short) 0);
        student.setViolationScore((short) 0);

        studentMapper.insert(student);
    }

    @Override
    public Student selectById(Integer id) {
        return studentMapper.selectById(id);
    }

    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);
    }

    @Override
    public void deleteById(Integer[] ids) {
        studentMapper.deleteById(ids);
    }

    @Override
    public void updateViolation(Integer id, Integer score) {
        LocalDateTime updateTime = LocalDateTime.now();
        studentMapper.updateViolation(id, score, updateTime);
    }
}
