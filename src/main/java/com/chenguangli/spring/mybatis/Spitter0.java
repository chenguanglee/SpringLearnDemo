package com.chenguangli.spring.mybatis;

import lombok.Data;

import java.util.Date;

/**
 * Create by chenguangli on 2019/4/14 0:07
 */
@Data
public class Spitter0 {

    private Integer id;
    private String user_name;
    private String password;
    private String full_name;
    private String email;
    private Date create_time;
    private Date modify_time;
    private Integer version;
}
