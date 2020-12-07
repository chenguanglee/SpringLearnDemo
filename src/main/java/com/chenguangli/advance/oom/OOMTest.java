package com.chenguangli.advance.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenguangli
 * @date 2020/11/8 17:08
 */
public class OOMTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        while (true) {
            list.add(new String("1231231231"));
        }
    }
}
