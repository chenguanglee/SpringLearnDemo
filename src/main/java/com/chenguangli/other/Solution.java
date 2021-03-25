package com.chenguangli.other;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @author chenguangli
 * @date 2021/1/11 23:32
 */
public class Solution {

    public static List<String> findAndSort(String fileName) throws IOException {
        File f = new File(fileName);
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String s;
            TreeSet<String> treeSet = new TreeSet<>((String o1, String o2) -> o2.compareTo(o1));
            while ((s = br.readLine()) != null) {
                if (s.contains("Login")){
                    treeSet.add(s);
                }
            }
            return new ArrayList<>(treeSet);
        }
    }

    public static void main(String[] args) throws IOException {
        File f = new File("E:/kddcup.data");
        BufferedReader br = new BufferedReader(new FileReader(f));
        String s;
//        TreeSet<String> treeSet = new TreeSet<>(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.compareTo(o1);
//            }
//        });

        TreeSet<String> treeSet = new TreeSet<>((String o1, String o2) -> o2.compareTo(o1));
        while ((s = br.readLine()) != null) {
            if (s.contains("Login")){
                treeSet.add(s);
            }
        }
        System.out.println();
    }
}
