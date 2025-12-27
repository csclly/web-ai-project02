package io.github.csclly.mapper;

import io.github.csclly.poji.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {
    @Select("select count(*) from emp left join dept on emp.dept_id = dept.id")
    public Long count();


    @Select("select emp.*, dept.name deptName from emp left join dept on emp.dept_id = dept.id order by emp.update_time desc limit #{start},#{pageSize}")
    public List<Emp> list(Integer start, Integer pageSize);
}
