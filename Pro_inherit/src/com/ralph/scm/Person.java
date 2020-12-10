package com.ralph.scm;

public class Person {
    String name;
    int age;

    public Person() {

    }

    public Person (String name,int age){
        this.name = name;
        this.age =  age;
    }

    public void eat() {
        System.out.println("we eat something");
    }

    public void sleep(){
        System.out.println("we sleeping");
    }
}
