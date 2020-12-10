package com.ralph.scm;

public class Student extends Person{
//    String name;
//    int age;
    String major;

    public Student(){

    }

    public Student(String name,int age, String major){
        this.name = name;
        this.age = age;
        this.major = major;
    }

//    public void eat(){
//        System.out.println("student eat");
//    }
//
//    public void sleep(){
//        System.out.println("student sleep");
//    }

    public void study(){
        System.out.println("student study");
    }
}
