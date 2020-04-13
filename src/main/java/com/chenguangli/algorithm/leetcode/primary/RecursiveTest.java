package com.chenguangli.algorithm.leetcode.primary;

import org.junit.Test;

import java.util.*;

/**
 * @author chenguangli
 * @date 2020/3/28 14:52
 */
public class RecursiveTest {

    public int sumArithmeticProgression(int n) {
        if (n <= 1) {
            return n;
        }
        return n + sumArithmeticProgression(n - 1);
    }

    public int sumGeometricSeries(int n) {
        if (n <= 2) {
            return n;
        }
        return n * sumGeometricSeries(n - 1);
    }

    /**
     * 斐波拉契数列
     *
     * @param n
     * @return
     */
    public int getFibonacci(int n) {
        if (n <= 2) {
            return 1;
        }
        return getFibonacci(n - 1) + getFibonacci(n - 2);
    }

    private Map<Integer, Integer> map = new HashMap<>();

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int a, b;
        if (map.get(n - 1) != null) {
            a = map.get(n - 1);
        } else {
            a = fib(n - 1)%1000000007;
            map.put(n-1, a);
        }

        if (map.get(n - 2) != null) {
            b = map.get(n - 2);
        } else {
            b = fib(n - 2)%1000000007;
            map.put(n-2, b);
        }
        return (a + b)%1000000007;
    }

    @Test
    public void testFib() {
//        int fibonacci1 = fib(45);
//        System.out.println(fibonacci1);
//        int fibonacci = getFibonacci(45);
//        System.out.println(fibonacci);
        int i = numWays(7);
        System.out.println(i);

    }

    public int getFrogJumpWay(int n) {
        if (n <= 2) {
            return n;
        }
        return getFrogJumpWay(n - 1) + getFibonacci(n - 2);
    }

    public int numWays(int n) {
        if (n == 0){
            return 1;
        }
        if (n<=2){
            return n;
        }
        int one = 1,two = 2,sum=0;
        for (int i = 0; i < n-2; i++) {
            sum = (one+two)%1000000007;
            one = two;
            two = sum;
        }
        return sum;
    }

    public Node reverseLinkedNode(Node node) {
        if (node == null || node.getNext() == null) {
            return node;
        }
        Node newNode = reverseLinkedNode(node.getNext());
        Node n1 = node.getNext();
        node.setNext(null);
        n1.setNext(node);
        return newNode;
    }

    /**
     * 杨辉三角
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<>();
        }
        return generate1(numRows, new ArrayList<>());
    }

    public List<List<Integer>> generate1(int numRows, List<List<Integer>> lists) {
        if (numRows == 1) {
            lists.add(Collections.singletonList(1));
            return lists;
        }
        List<List<Integer>> lists1 = generate1(numRows - 1, lists);
        List<Integer> list = new ArrayList<>();
        List<Integer> lastList = lists1.get(numRows - 2);
        for (int i = 0; i < numRows; i++) {
            int a = 0, b = 0;
            if (i > lastList.size() - 1) {
                a = 0;
            } else {
                a = lastList.get(i);
            }
            if (i - 1 < 0) {
                b = 0;
            } else {
                b = lastList.get(i - 1);
            }
            list.add(a + b);
        }
        lists1.add(list);
        return lists1;
    }

    @Test
    public void testYanghuiTriangle() {
        List<List<Integer>> generateList = generate(4);
        System.out.println("-----");
    }


    @Test
    public void testSum() {
        System.out.println(sumArithmeticProgression(50));
        System.out.println(sumGeometricSeries(5));
        System.out.println(getFibonacci(8));
        System.out.println(getFibonacci(3));
        Node one = new Node();
        one.setVal(5);
        Node two = new Node();
        two.setVal(4);
        Node three = new Node();
        three.setVal(3);
        Node four = new Node();
        four.setVal(2);
        Node five = new Node();
        five.setVal(1);
        four.setNext(five);
        three.setNext(four);
        two.setNext(three);
        one.setNext(two);
        Node resultNode1 = reverseLinkedNode1(one);
        Node resultNode = reverseLinkedNode(one);
        System.out.println(resultNode);

        Node next = one.getNext();
        next.setNext(one);
    }


    public Node reverseLinkedNode1(Node node) {
        if (node == null || node.getNext() == null) {
            return node;
        }
        Node nodes1 = reverseLinkedNode1(node.getNext());
        node.getNext().setNext(node);
        node.setNext(null);
        return nodes1;
    }


}
