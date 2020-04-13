package com.chenguangli.base.clone;


import java.util.Arrays;

/**
 * java中的克隆
 *
 * @author lee
 * @date 2020/4/10 20:41
 */
public class Clone {

    private int a;
    private String b = "123";
    private Student c = new Student(1,"str");

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
//        Clone clone = new Clone();
//        Clone clone1 = (Clone) clone.clone();
//        clone.a = 1;
//        clone.c.setA(123333);
//        System.out.println();
//        int[] array1 = new int[]{1,2,3};
//        int[] array2 = Arrays.copyOf(array1, array1.length);
//        int[] array2 = array1.clone();
//        array2[1] = 3;
//        System.out.println();
        Clone[] clones1 = new Clone[]{new Clone(),new Clone()};
        Clone[] clones2 = Arrays.copyOf(clones1, clones1.length);
//        Clone[] clones2 = clones1.clone();
//        Student[] students1 = new Student[]{new Student(1,"1"),new Student(2,"2")};
//        Student[] students2 = students1.clone();
//        System.out.println();
//
//        int[][] arrayd1 = new int[][]{{1,2,3},{4,5,6}};
//        int[][] arrayd2 = arrayd1.clone();
//        arrd2[0][0] = 2;
        System.out.println();


    }
}


