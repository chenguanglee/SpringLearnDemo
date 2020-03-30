package com.chenguangli.algorithm.leetcode.primary;

import org.junit.Test;

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

    public int getFibonacci(int n) {
        if (n <= 2) {
            return 1;
        }
        return getFibonacci(n - 1) + getFibonacci(n - 2);
    }

    public int getFrogJumpWay(int n) {
        if (n <= 2) {
            return n;
        }
        return getFrogJumpWay(n - 1) + getFibonacci(n - 2);
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
        Node resultNode = reverseLinkedNode(one);
        System.out.println(resultNode);

        Node next = one.getNext();
        next.setNext(one);
    }


}
