package com.ralph.java;

public class PersonTest {
    public static void main(String[] args) {
        //匿名对象---类有名字 对象没有名字
        method(new Student());


        Worker worker = new Worker();
        //非匿名的类，非匿名的对象---有名的类Worker，有名的对象worker
        method1(worker);

        // 非匿名的类 匿名的对象--- 有类名Worker， 没有对象
        method1(new Worker());

        //创建了一个匿名子类的对象：p 使用父类的名字来充当一下
        Person p = new Person() {
            @Override
            public void eat() {
                System.out.println("fuck");
            }

            @Override
            public void breath() {
                System.out.println("zooben");
            }
        };

        method1(p);
    }



    public static void method1(Person p ){
        p.eat();
        p.walk();
    }

    public static void method(Student s){

    }
}

class Worker extends Person{

    @Override
    public void eat() {
    }

    @Override
    public void breath() {
    }

}
