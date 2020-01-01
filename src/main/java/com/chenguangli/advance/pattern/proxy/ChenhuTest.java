package com.chenguangli.advance.pattern.proxy;

/**
 * @author chenguangli
 * @date 2019/6/22 22:42
 */
public class ChenhuTest {

    public static final String CLAZZ_NAME = "com.chenguangli.advance.pattern.proxy.Req";

    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName(CLAZZ_NAME);
        Req Req0 = (Req) clazz.newInstance();

        Class<Req> reqClass = Req.class;
        Req req = reqClass.newInstance();


        Integer chen = 12;
        Integer hu = 12;
        if (chen == hu) {
            System.out.println("");
        }

        String str1 = "12";
        String str2 = new String("12");
        String str3 = "12";
        if (str1 == str2) {
            System.out.println("str1 ==");
        }

        if (str1 == str3) {
            System.out.println("str2 ==");
        }


        int[] arry1;
        int[] arry2 ={1,2,3};
        int[] arry3 = new int[5];
        int[] arry4 = new int[]{1,2,3,4,5};

    }
}
