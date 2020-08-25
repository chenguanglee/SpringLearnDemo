package com.chenguangli.test;

import org.junit.Test;

import javax.annotation.PreDestroy;
import java.lang.reflect.Field;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chenguangli
 * @date 2020/3/14 16:51
 */
public class TestOne {

    @Test
    public void test1() {
        double a = 42.0;
        int b = 42;
        if (a == b) {
            System.out.println("a等于b");
        }

    }

    @Test
    public void testFinally() {
        try {
            System.out.println("try");
            System.exit(1);
        } catch (Exception e) {
            System.out.println("exp");
        } finally {
            int a = 2 / 0;
            System.out.println("finally");
        }
    }

    @Test
    public void testSwapInteger() {

        Integer c = 1;
        Integer d = 2;
        swap(c, d);
        System.out.println("c=" + c + " d=" + d);
        Integer a = new Integer(1);
        Integer b = new Integer(2);
        swap2(a, b);
        System.out.println("a=" + a + " b=" + b);
    }

    public void swap(Integer num1, Integer num2) {
        int temp = num1;
        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            field.set(num1, num2);
            //num1 = Integer.valueOf(num2);
            field.set(num2, new Integer(temp));
            //num2 = Integer.valueOf(temp);
            System.out.println("num1=" + num1 + " num2=" + num2);

            Class<?>[] declaredClasses = Integer.class.getDeclaredClasses();
            Class<?> declaredClass = declaredClasses[0];
            Field cache = declaredClass.getDeclaredField("cache");
            cache.setAccessible(true);
            Object o = cache.get(num1);
//            Integer[] d = (Integer[]) o;
//            int l = d[129];
//            int k = d[130];
//            d[129] = new Integer(k);
//            d[130] = new Integer(l);
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void swap2(Integer num1, Integer num2) {
        int temp = num1;

        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            field.set(num1, num2);
            //num1 = Integer.valueOf(num2);
            field.set(num2, temp);
            //num2 = Integer.valueOf(temp);
            System.out.println("num1=" + num1 + " num2=" + num2);

            Class<?>[] declaredClasses = Integer.class.getDeclaredClasses();
            Class<?> declaredClass = declaredClasses[0];
            Field cache = declaredClass.getDeclaredField("cache");
            cache.setAccessible(true);
            Object o = cache.get(num1);
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test0325() {
        int i = Sum_Solution(50);
        System.out.println(i);
    }

    public int Sum_Solution(int n) {
        int sum = n;
        boolean flag = n > 0 && (sum += Sum_Solution(n - 1)) > 0;
        return sum;
    }

    public int sum(int sum, int n) {
        if (n == 0) {
            return sum;
        }
        return sum(sum + n, --n);
    }

    @Test
    public void test0429() {
        double a = 2.10000;
        System.out.println(Math.pow(a, 3));
    }

    @Test
    public void testExecutor() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> System.out.println(11));
        executor.shutdown();
    }


    @Test
    public void testQuickSort() {
        quickSort(new int[]{6, 7, 4, 3, 2, 1});
    }

    public void quickSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        System.out.println();
    }

    public void sort(int[] nums, int left, int right) {
        if (right > left) {
            int p = getPartition(nums, left, right);
            sort(nums, left, p - 1);
            sort(nums, p + 1, right);
        }
    }

    public int getPartition(int[] nums, int left, int right) {
        int k = left + 1;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < nums[left]) {
                int tmp = nums[i];
                nums[i] = nums[k];
                nums[k] = tmp;
                k++;
            }
        }
        int tmp = nums[left];
        nums[left] = nums[--k];
        nums[k] = tmp;
        return k;
    }

    @Test
    public void ip() throws Exception{
        Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();

    }
}
