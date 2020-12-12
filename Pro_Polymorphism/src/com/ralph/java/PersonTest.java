package com.ralph.java;

/**
 * @author ralph
 * @create 2020-12-12 20:29
 */
public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.eat();

        Man man = new Man();
        man.eat();
        man.age = 25;
        man.earnMoney();

    // 子类对象的多态性：父类的引用指向子类的对象
    // 虚拟调用
        Person p2 = new Man();
        System.out.println("#######[多态性的使用]子类重写父类的方法#########");
        p2.eat();
        p2.walk();
        System.out.println(p2.id);

//        Person p3 = new Woman();

    }
}
