package com.ralph.StingClass;

import org.junit.Test;

/**
 * Description:String的使用
 * Class:
 * Author:     ralph
 **/
public class StringTest {

    @Test
    public void Test1(){
        String s1 = "abc";
        String s2 = "abc";
        s1 = "hello";

        System.out.println(s1);
        System.out.println(s2);
    }


    @Test
    public void Test2(){
        String s11 = "javaEE";
        String s22 = "javaEE";
        String s33 = new String("javaEE");
        String s44 = new String("javaEE");

        System.out.println(s11 == s22);//true
         System.out.println(s11 == s33);//false
         System.out.println(s11 == s44);//false
         System.out.println(s33 == s44);//false
    }



    @Test
    public void Test3(){
        Person p1 = new Person();
        p1.name = "Tom";
        Person p2 = new Person();
        p2.name = "Tom";
        System.out.println(p1.name .equals( p2.name)); // true
        System.out.println(p1.name == p2.name); // true
        System.out.println(p1.name == "Tom"); //true
        String s10 = new String("bcde");
        String s20 = new String("bcde");
        System.out.println(s10==s20); // false 堆当中的是否相等
    }


    @Test
    public void Test4(){

        String s21 = "hello";
        String s22 = "world";
        String s23 = "hello" + "world";
        String s24 = s21 + "world";
        String s25 = s21 + s22;
        String s26 = (s21 + s22).intern();

        System.out.println(s23 == s24);
        System.out.println(s23 == s25);
        System.out.println(s24 == s25);
        System.out.println(s23 == s26);

    }


    @Test
    public void Test5(){
        String s = "0";
        for (int i =1;i<=5;i++){
            s += i;
        }
        System.out.println(s);
    }

    @Test
    public void Test6(){
        String s1 = new String("1");
        for (int i =1;i<=5;i++){
            s1 += i;
        }
        System.out.println(s1);
    }



}

class Person{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
}



