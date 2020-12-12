package com.ralph.java;

/**
 * @author ralph
 * @create 2020-12-12 20:28
 */
public class Man extends Person{
    boolean isSmoking;

    int id = 1002;

    public void earnMoney(){
        System.out.println("Men are responsible for earning money to support the family");
    }

    public void eat(){
        System.out.println("Men eat more meat and grow muscles");
    }

    public void walk(){
        System.out.println("Man walking domineeringly");
    }
}
