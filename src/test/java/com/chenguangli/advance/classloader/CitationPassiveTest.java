package com.chenguangli.advance.classloader;

import com.chenguangli.advance.classloader.bean.SubClass4CitationPassive;
import com.chenguangli.advance.classloader.bean.SubService4CitationPassive;
import com.chenguangli.advance.classloader.bean.SuperClass4CitationPassive;
import org.junit.Test;

/**
 * <功能描述>被动引用测试类</功能描述>
 *
 * @author: chenhu
 * @date: 2020/1/5 14:45
 */
public class CitationPassiveTest {

    /**
     * 子类调用父类静态字段，只会初始化父类
     */
    @Test
    public void test_1(){
        System.out.println(SubClass4CitationPassive.SUPER_VAR);
    }

    /**
     * 通过数组定义引用类，不会触发此类的初始化
     */
    @Test
    public void test_2(){
        SuperClass4CitationPassive[] array = new SuperClass4CitationPassive[3];
    }

    /**
     * 常量再编译阶段已存入调用类的常量池中
     * 本质上并没有直接引用到定义常量的类
     * 因此不会触发定义常量类的初始化
     */
    @Test
    public void test_3(){
        System.out.println(SuperClass4CitationPassive.FINAL_VAR);
    }

    @Test
    public void test_4(){
        System.out.println(SubService4CitationPassive.INTERFACE_VAR);
    }
}
