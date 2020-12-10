package com.ralph.java;

public class Student extends Person{
    String major;

    public Student(){
    }

    public Student(String major){
        this.major = major;
    }

    public void study(){
        System.out.println("Fucking " + major);
    }
    //Rewrite the method of the parent class
    public void eat(){
        System.out.println("Fucking more eat");
    }

    private  void show(){
        System.out.println("AAA");
    }


}
