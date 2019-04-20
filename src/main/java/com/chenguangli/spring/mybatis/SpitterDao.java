package com.chenguangli.spring.mybatis;

import com.chenguangli.spring.db.Spitter;
import org.apache.ibatis.annotations.*;
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
    Spitter getSpitter(@Param("id") int id);

    @Select("SELECT * FROM spitter where id = #{id}")
    @ResultMap("baseResultMap")
    Spitter getSpitter0(@Param("id") int id);


    @Update("update spitter set email=#{arg0} where user_name=#{arg1}")
    int updateSpitter(String email, String userName);

    String getUserName(int id);

    int updateSpitter0(Spitter spitter);

    /**
     * @param spitter
     * @return
     */
    @Insert("insert into spitter(user_name,password,full_name,email,create_time,modify_time) " +
            "values(#{userName},#{password},#{fullName},#{email},#{createTime},#{modifyTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insertRow(Spitter spitter);


    @Insert("insert into spitter(user_name,password,full_name,email,create_time,modify_time) " +
            "values(#{userName},#{password},#{fullName},#{email},#{createTime},#{modifyTime})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()",
            keyProperty = "id",
            keyColumn = "id",
            resultType = int.class,
            before = false)
    int insertRow0(Spitter spitter);

    /**
     * @return
     */
    @Delete("delete from spitter where id=#{id}")
    int deleteRow(int id);

    @SelectProvider(type = SpitterProvider.class, method = "selectById")
    Spitter selectById(Integer id);
}
