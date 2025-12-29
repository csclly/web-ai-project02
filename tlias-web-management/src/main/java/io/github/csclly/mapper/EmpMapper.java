package io.github.csclly.mapper;

import io.github.csclly.poji.Emp;
import io.github.csclly.poji.EmpQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    /*
    * 原始分页查询
    */
//    @Select("select count(*) from emp left join dept on emp.dept_id = dept.id")
//    public Long count();
//
//
//    @Select("select emp.*, dept.name deptName from emp left join dept on emp.dept_id = dept.id order by emp.update_time desc limit #{start},#{pageSize}")
//    public List<Emp> list(Integer start, Integer pageSize);


    public List<Emp> list(EmpQueryParam empQueryParam);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) VALUES(#{username}, #{name}, #{gender}, #{phone}, #{job}, #{salary}, #{image}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime})")
    void insert(Emp emp);


    void deleteByIds(List<Integer> ids);


    Emp getById(Integer id);


    void updateById(Emp emp);
}
