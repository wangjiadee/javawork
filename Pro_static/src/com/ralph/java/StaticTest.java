package com.ralph.java;

public class StaticTest {
    public static void main(String[] args) {
        Chinese.nation = "ZK";
        Chinese c1 = new Chinese();
        c1.name = "mdzz";
        c1.age  = 50;
        c1.nation = "JP";

        Chinese c2 = new Chinese();
        c2.name = "sb";
        c2.age = 21;
        c2.nation = "TW";
        System.out.println(c2.nation);

        c1.eat();
        Chinese.show();
//        Chinese.info();
    }
}


class Chinese{
    String name;
    int age;
    static String nation;

    public void eat(){
        System.out.println("Fucking eating");
//        调用非静态结构
        this.info();
        System.out.println("name: "+ name);
//        调用静态结构
        walk();
        System.out.println("nation: " + nation);

    }

    public static void show(){
        System.out.println("Fucking u!");
//        eat();
        walk();

    }
    public   void  info(){
        System.out.println("name : " + name);
    }

    public static void walk(){
        System.out.println("walking");
    }
}
