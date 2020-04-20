package com.chenguangli.base.clone;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author chenguangli
 * @date 2020/4/19 23:43
 */
@Data
@AllArgsConstructor
public class InfoA implements Cloneable{
    int a;
    String b;
    Student c;

    @Override
    protected InfoA clone() throws CloneNotSupportedException {
        InfoA clone = (InfoA)super.clone();
        clone.c = c.clone();
        return clone;
    }

    public static void main(String[] args) throws CloneNotSupportedException{
        InfoA infoA = new InfoA(1,"s",new Student(1,"ss"));
        Object clone = infoA.clone();
        System.out.println(clone);
    }
}
