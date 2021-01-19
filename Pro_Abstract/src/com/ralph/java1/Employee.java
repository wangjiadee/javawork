package com.ralph.java1;

public abstract class Employee {
    private String name;
    private int id;
    private double salary;
    public Employee(){
        super();
    }

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    //Set the method as an abstract method
    public abstract void work();
}
