package com.ralph.java;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class Person {
    String name;
    int age;

    public Person(){

    }

    public  Person(String name,int age ){
        this.name = name;
        this.age = age;
    }

    public void eat(){
        System.out.println("Fucking eat");
    }

    public void walk(int distance){
        System.out.println("Fucking walk " + distance);
    }

    private  void show(){
        System.out.println("AAA");
    }
}
