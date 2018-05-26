package com.leo.basepool;

public class Test {
    private static final String s11="hello";
    private static final String s22="world";
    public static void main(String[] args) {
        Integer i1 = 10;
        Integer i2 = 10;
        Integer i3 = 20;
        Integer i11 = new Integer(10);
        Integer i22 = new Integer(10);
        Integer i33 = new Integer(20);
        System.out.println(i1 == i2);
        System.out.println(i1 == i11);
        System.out.println(i11 == i22);
        System.out.println(i3 == (i1 + i2));
        System.out.println(i3 == (i11 + i22));
        System.out.println(i33 == (i1 + i2));
        System.out.println(i33 == (i11 + i22));
        
        /*String s1="hello";
        String s2="world";
        String s3="helloworld";
        String s4=s11+s22; //因为s11和s22已经在加载前就编译了，相当于常量，所以不会调用stringbffer的append方法重新生成对象
        String s5= s1+s2; //stringbffer的append方法重新生成对象
        String s6=s5.intern();
        String s7="hello"+new String("world");
        System.out.println(s3==s4);
        System.out.println(s3==s5);
        System.out.println(s4==s5);
        System.out.println(s4==s6);
        System.out.println(s3==s7);
        System.out.println(s4==s7);
        System.out.println(s5==s7);*/
    }
}
