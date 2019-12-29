package com.chenguangli.generic;

/**
 * @author chenguangli
 * @date 2019/12/29 17:37
 */
public class GenericDemo<T> {


    /**
     * 泛型类方法
     *
     * @param t
     * @return
     */
    public T fun(T t) {
        return t;
    }

    /**
     * 泛型方法
     *
     * @param t
     * @param <T>
     * @return
     */
    public  <Q> Q fun2(Q t) {
        return t;
    }
}
