package com.chenguangli.base.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author chenguangli
 * @date 2019/8/25 11:46
 */
public class DeleteList {

    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        test1(list);
    }

    /**
     * 错误的删除方式
     * 调用的java.util.ArrayList#remove(java.lang.Object)这个删除方式后, modCount的值++, 导致
     * java.util.ArrayList.Itr#checkForComodification()这个方法抛出异常
     *
     * @param list
     */
    public static void test1(List<String> list) {
        for (String s : list) {
            if (s.equals("3")) {
                list.remove(s);
            }
        }
    }

    /**
     * 正确的删除方式
     *
     * @param list
     */
    public static void test2(List<String> list) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String a = iterator.next();
            if (a.equals("3")) {
                iterator.remove();
            }
        }
    }

    /**
     * 正确的删除方式
     *
     * @param list
     */
    public static void test3(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("5")) {
                list.remove(i);
            }
        }
    }

    /**
     * 错误的删除方式
     *
     * @param list
     */
    public static void test4(List<String> list) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String a = iterator.next();
            if (a.equals("3")) {
                list.remove(a);
            }
        }
    }

    /**
     * 错误的删除方式
     *
     * @param list
     */
    public static void test5(List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.remove(i);
        }
    }
}
