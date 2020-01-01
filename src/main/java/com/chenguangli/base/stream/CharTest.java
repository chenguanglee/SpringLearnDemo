package com.chenguangli.base.stream;

import org.junit.Test;

import java.io.File;

/**
 * @author chenguangli
 * @date 2019/4/24 23:18
 */
public class CharTest {

    @Test
    public void char0() {
        System.out.println(File.separator);
        String str = "严";
        for (int i = 0; i < str.length(); i++) {
            System.out.println((int) str.charAt(i));
        }
    }
}
