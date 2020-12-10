package com.ralph.scm;

public class PersonTest {
    public static void main(String[] args){
        Person p1 = new Person();
        p1.age = 12;
        p1.eat();

        Student s1 = new Student();
        s1.eat();
        s1.sleep();

        Creature c = new Creature();
        c.breath();
    }
}
