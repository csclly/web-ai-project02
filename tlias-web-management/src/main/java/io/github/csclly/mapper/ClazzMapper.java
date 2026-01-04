package io.github.csclly.mapper;

import io.github.csclly.poji.Clazz;
import io.github.csclly.poji.ClazzQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClazzMapper {


    @Insert("insert into clazz(name, room, begin_date, end_date, master_id, subject, create_time, update_time) values (#{name},#{room},#{beginDate}, #{endDate}, #{masterId}, #{subject}, #{createTime}, #{updateTime})")
    void insert(Clazz clazz);


    @Select("select id, name, room, begin_date, end_date, master_id, subject, create_time, update_time from clazz")
    List<Clazz> findAll();

    List<Clazz> list(ClazzQueryParam clazzQueryParam);

    @Select("select * from clazz where id = #{id}")
    Clazz selectById(Integer id);



    void updateById(Clazz clazz);

    @Delete("delete from clazz where id = #{id}")
    void deleteById(Integer id);

    Integer countStudentByClazzId(Integer id);
}
