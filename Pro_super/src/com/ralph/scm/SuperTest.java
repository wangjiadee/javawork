package com.ralph.scm;

public class SuperTest {
    public static void main(String[] args) {
        Student stu = new Student();
        stu.show();
        stu.study();

        Student s = new Student("Tom",12,"Devops");
        s.show();
    }
}
