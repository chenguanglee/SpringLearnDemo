package com.chenguangli.spring.mybatis;

import org.apache.ibatis.jdbc.SQL;

/**
 * @author chenguangli
 * @date 2019/4/20 21:54
 */
public class SpitterProvider {

    public SpitterProvider() {
    }

    public String selectById(Integer id) {
        return new SQL() {
            {
                SELECT("id", "user_name", "password");
                FROM("spitter");
                WHERE("id=#{id}");
            }
        }.toString();
    }
}
