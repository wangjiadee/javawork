package com.ralph.java;

public class Test1 {
    public static void main(String[] args) {
        Bank  b1 =  Bank.getInstance();
        Bank  b2 =  Bank.getInstance();
        System.out.println(b1 == b2);

    }
}


class Bank{
//    构造私有化类的构造器
    private Bank(){

    }

//    私有化的内部对象 ---- 声明的对象 必须是静态的
    private static Bank instance = new Bank();

//    提供方法 得到对象
    public static Bank getInstance(){
        return instance;
    }
}