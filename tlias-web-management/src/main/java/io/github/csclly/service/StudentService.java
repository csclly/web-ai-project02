package io.github.csclly.service;

import io.github.csclly.poji.PageResult;
import io.github.csclly.poji.Student;
import io.github.csclly.poji.StudentQueryParam;

public interface StudentService {
    PageResult<Student> page(StudentQueryParam studentQueryParam);

    void add(Student student);

    Student selectById(Integer id);

    void update(Student student);

    void deleteById(Integer[] ids);

    void updateViolation(Integer id, Integer score);
}
