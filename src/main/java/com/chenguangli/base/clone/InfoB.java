package com.chenguangli.base.clone;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;

/**
 * @author chenguangli
 * @date 2020/4/22 0:31
 */
@Data
@AllArgsConstructor
public class InfoB implements Serializable {

    private static final long serialVersionUID = -418145923938137568L;

    int a;
    String c;
    Student d;

    public static void main(String[] args) throws Exception{
//        InfoB infoB = new InfoB(1,"2",new Student(1,"3"));
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        ObjectOutputStream oos = new ObjectOutputStream(baos);
//        oos.writeObject(infoB);
//        //从流中读取
//        ObjectInputStream ios = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
//        InfoB infoB1 = (InfoB) ios.readObject();
//        System.out.println();



        //serialVersionUID作用
//        InfoB infoB = new InfoB(1,"2",new Student(1,"3"));
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("infob.obj"));
//        oos.writeObject(infoB);

        ObjectInputStream ios = new ObjectInputStream(new FileInputStream("infob.obj"));
        InfoB infoB1 = (InfoB) ios.readObject();
        System.out.println();
    }
}
