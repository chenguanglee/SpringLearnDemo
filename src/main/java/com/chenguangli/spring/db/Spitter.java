package com.chenguangli.spring.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Spitter {
    private int id;
    private String userName;
    private String password;
    private String fullName;
    private String email;
    private Date createTime;
    private Date modifyTime;
    private int version;
}
