package com.chenguangli.base.stream;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * @author chenguangli
 * @date 2020/3/31 23:52
 */
@Data
@AllArgsConstructor
public class User {

    private int age;

    private String name;

    private int length;

    public static void main(String[] args) {
        User user = new User(1, "lee", 1);
        String s = JSONObject.toJSONString(user);
        User user1 = JSON.parseObject(s, User.class);
        System.out.println();
    }
}
