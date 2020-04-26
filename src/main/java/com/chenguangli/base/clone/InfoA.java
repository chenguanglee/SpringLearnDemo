package com.chenguangli.base.clone;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;

/**
 * @author chenguangli
 * @date 2020/4/19 23:43
 */
@Data
@AllArgsConstructor
public class InfoA implements Cloneable {
    int a;
    String b;
    Student c;

    @Override
    protected InfoA clone() throws CloneNotSupportedException {
        InfoA clone = (InfoA) super.clone();
        //3.
        clone.c = c.clone();
        return clone;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        //1.查看clone后的结果
//        InfoA infoA = new InfoA(1, "s", new Student(1, "ss"));
//        Object clone = infoA.clone();
//        System.out.println(clone);

        //2.证明基本数据类型和引用类型复制的差异
//        InfoA infoA = new InfoA(1, "s", new Student(1, "ss"));
//        Object clone = infoA.clone();
//        infoA.a=2;
//        infoA.c.setA(2);
//        System.out.println(clone);

        //3.如何实现引用类型的完全拷贝
//        InfoA infoA = new InfoA(1, "s", new Student(1, "ss"));
//        Object clone = infoA.clone();
//        infoA.a=2;
//        infoA.c.setA(2);
//        System.out.println(clone);

        //4.基本数据类型数组的拷贝
//        int[] arrays = new int[]{1, 2, 3};
//        int[] arraysClone = arrays.clone();
//        arrays[0] = 2;
//        System.out.println();
        //5.引用数据类型数组的拷贝
//        InfoA[] infoArray = new InfoA[]{new InfoA(1, "s", new Student(1, "ss")), new InfoA(1, "s", new Student(1, "ss")), new InfoA(1, "s", new Student(1, "ss"))};
//        InfoA[] clone = infoArray.clone();
//        System.out.println();

        //6.Arrays.copyOf()
        //基本数据类型
        int[] arrays = new int[]{1, 2, 3};
        int[] ints = Arrays.copyOf(arrays, 1);
        ints[0]=2;
        System.out.println();
        //引用数据类型
        InfoA[] infoArray = new InfoA[]{new InfoA(1, "s", new Student(1, "ss")), new InfoA(1, "s", new Student(1, "ss")), new InfoA(1, "s", new Student(1, "ss"))};
        InfoA[] infoAS = Arrays.copyOf(infoArray, 1);
        System.out.println();


    }
}
