package com.ralph.java;

public class Test2 {
    public static void main(String[] args) {
        Order o1 = Order.getInstance();
        Order o2 = Order.getInstance();

        System.out.println(o1 == o2);
    }


}
//懒汉式
class Order{
    //私有化类的构造器
    private Order(){

    }

    //声明当前类的对象，没有初始化 也是static
    private static Order instance = null;

    //
    public static Order getInstance(){
        if(instance == null){
            instance = new Order();
        }
        return instance;
    }
}