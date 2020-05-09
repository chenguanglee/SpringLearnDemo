package com.chenguangli.base.lock;

/**
 * @author chenguangli
 * @date 2020/5/4 17:47
 */
public class LockTest {

    private Object obj = new Object();

    public void test1() {
        synchronized (this.obj) {
            System.out.println(this.obj.hashCode());
        }
    }

    public static void main(String[] args) {
        LockTest lockTest = new LockTest();
        lockTest.test1();
        System.out.println(lockTest.obj.hashCode());
    }
}
