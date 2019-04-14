package com.chenguangli.spring.mybatis;

import com.chenguangli.spring.db.Spitter;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;

/**
 * Create by chenguangli on 2019/4/13 23:10
 */
public interface SpitterDao {

    @Select("SELECT * FROM spitter where id = #{id}")
    //@ResultMap("spitter")
    Spitter getSpitter(@Param("id") int id);
}
