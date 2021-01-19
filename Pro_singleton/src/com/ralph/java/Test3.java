package com.ralph.java;

public class Test3 {
    public static void main(String[] args) {
        Bank b1 = Bank.getInstance();
        Bank b2 = Bank.getInstance();
        System.out.println(b1 == b2);
        Order o1 = Order.getInstance();
        Order o2 = Order.getInstance();

        System.out.println(o1 == o2);
    }


}


class Bank{
    private Bank(){

    }

    private static Bank instance = new Bank();

    public static Bank getInstance(){
        return instance;
    }
}


class Order {

    private Order() {

    }

    private static Order instance = null;

    public static Order getInstance() {
        if (instance == null) {
            instance = new Order();

        }
        return instance;
    }
}