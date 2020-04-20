package com.chenguangli.base.clone;

/**
 * @author chenguangli
 * @date 2020/4/19 23:38
 */
public class Info {

    public static void main(String[] args) throws Exception{
        Info info = new Info();
        Info clone = (Info) info.clone();
    }
}
