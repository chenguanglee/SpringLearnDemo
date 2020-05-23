package com.chenguangli.base.stream;

import java.util.Scanner;

/**
 * @author chenguangli
 * @date 2020/5/23 11:25
 */
public class InputTest {


    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int i = scanner.nextInt();
//        if (i < 1000 || i > 9999) {
//            throw new RuntimeException("卡号异常!");
//        }
//        int sum = 0;
//        while (i > 0) {
//            sum += i % 10;
//            i /= 10;
//        }
//        System.out.println(sum);
//        if (sum > 20) {
//            System.out.println("是幸运客户");
//        } else {
//            System.out.println("不是");
//        }


        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int i = k;
        int sum = 0;
        while (i > 0) {
            int c = i % 10;
            sum += c * c * c;
            i /= 10;
        };;;;;;;;;
        System.out.println(sum);
        if (k == sum) {
            System.out.println("是");
        } else {
            System.out.println("不是");
        }
    }
}
