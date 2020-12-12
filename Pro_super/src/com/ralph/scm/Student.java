package com.ralph.scm;

public class Student extends Person {

    String major;
    int id = 1002;

    public Student(){

    }

    public Student(String major){
        this.major =major;
    }

    public Student(String name, int age,String major){
        super(name,age);
        this.major = major;

    }

    @Override
    public void eat() {
        System.out.println("Fucking eat more food");
    }

    public void study() {
        System.out.println("Fucking study");
        super.eat();
    }

    public void show(){
        System.out.println("Fucking name: " + this.name + "Fucking age: "+ super.age);
        System.out.println("Fucking id : " + id );
        //Call the properties of the parent class
        System.out.println("Fucking id : " + super.id );
    }
}
