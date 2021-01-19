package com.ralph.java;

public class BlockTest {
    public static void main(String[] args) {
        String desc = Person.desc;
        System.out.println(desc);

        Person p1 = new Person();
        Person p2 = new Person();
        System.out.println(p1.age);

    }
}


class Person{
    //属性
    String name;
    int age;
    static String desc = "Fucking u";

    //构造器
    public  Person(){

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    //代码块
    {
        System.out.println("this is code_block");
        age = 19;
    }

    {
        System.out.println("this is code_block 2");
        age = 19;
    }

    static {
        System.out.println("this is static code_block");
        desc = "llalalal";
    }
    static {
        System.out.println("this is static code_block 2");
        desc = "llalalal2";
    }


    //方法
    public void eat(){
        System.out.println("吃饭");
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

}