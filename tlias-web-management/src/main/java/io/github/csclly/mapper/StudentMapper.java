package io.github.csclly.mapper;

import io.github.csclly.poji.Student;
import io.github.csclly.poji.StudentQueryParam;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {


    List<Student> list(StudentQueryParam studentQueryParam);

    @Insert("insert into student(name, no, gender, phone, id_card, is_college, address, " +
            "degree, graduation_date, clazz_id, violation_count, violation_score, create_time, update_time) " +
            "VALUES (#{name}, #{no}, #{gender}, #{phone}, #{idCard}, #{isCollege}, #{address}, " +
            "#{degree}, #{graduationDate}, #{clazzId}, #{violationCount}, #{violationScore}, #{createTime}, #{updateTime})")
    void insert(Student student);

    @Select("select * from student where id = #{id}")
    Student selectById(Integer id);

    void update(Student student);

    void deleteById(Integer[] ids);

    @Update("update student set violation_count = violation_count+1, violation_score = violation_score+#{score}, update_time = #{updateTime} where id = #{id}")
    void updateViolation(Integer id, Integer score, LocalDateTime updateTime);

    @MapKey("clazz")
    List<Map<String, Object>> countStudentCountData();

    List<Map<String, Object>> countStudentDegreeData();
}
