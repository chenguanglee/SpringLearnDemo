package com.chenguangli.spring.mybatis;

import com.chenguangli.spring.db.Spitter;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;

/**
 * Create by chenguangli on 2019/4/13 23:10
 */
public interface SpitterDao {

    @Results(id = "baseResultMap", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "password", column = "password"),
            @Result(property = "fullName", column = "full_name"),
            @Result(property = "email", column = "email"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "modifyTime", column = "modify_time"),
            @Result(property = "version", column = "version")
    })
    @Select("SELECT * FROM spitter where id = #{id}")
    //@ResultMap("baseResultMap")
    Spitter getSpitter(@Param("id") int id);

    @Select("SELECT * FROM spitter where id = #{id}")
    @ResultMap("baseResultMap")
    Spitter getSpitter0(@Param("id") int id);
}
