package com.ralph.Exer1;

public class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }



    private void show(){
        System.out.println("[Fucking u,student ] :" );
    }

    private String display(String nation){
        System.out.println(" My nation：" + nation);
        return nation;
    }

}
