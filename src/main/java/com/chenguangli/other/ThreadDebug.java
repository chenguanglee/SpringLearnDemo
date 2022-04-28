package com.chenguangli.other;

import java.io.IOException;

/**
 * @author chenguangli
 * @date 2021/3/25 21:58
 */
public class ThreadDebug {

    public static void main(String[] args) throws IOException {
        String a ="123";
        System.out.println(a.hashCode());
        System.out.println(System.identityHashCode(a));

        ThreadDebug threadDebug = new ThreadDebug();
        System.out.println(threadDebug.hashCode());
        System.out.println(System.identityHashCode(threadDebug));
    }

    private static void method1() {
        int a = 1;
        int b = 2;
        int c = a + b;
        System.out.println(c);
    }
}

