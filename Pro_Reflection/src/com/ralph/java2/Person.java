package com.ralph.java2;

@MyAnnotation(value = "SB")
public class Person extends Creature<String> implements Comparable<String>, MyInterface  {
    private  String name;
    int age;
    public int id;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @MyAnnotation(value = "WDNMD")
    private Person(String name) {
        this.name = name;
    }
    @MyAnnotation
    private String show(String nation){
        System.out.println("我的国籍是：" + nation);
        return nation;
    }

    @Override
    public void info() {
        System.out.println("Person?");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
