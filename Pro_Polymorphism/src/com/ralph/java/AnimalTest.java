package com.ralph.java;
import java.sql.Connection;
/**
 * @author ralph
 * @create 2020-12-12 20:44
 */
public class AnimalTest {
    public static void main(String[] args) {
        AnimalTest test = new AnimalTest();
        System.out.println("[多态性直接new对象]");
        test.func(new Dog());
        test.func(new Cat());
    }

    public void  func(Animal animal){
        animal.eat();
        animal.shout();
    }
}


class Animal{


    public void eat(){
        System.out.println("Animals: eating");
    }

    public void shout(){
        System.out.println("Animal: called");
    }


}

class Dog extends Animal{
    public void eat(){
        System.out.println("Dog eating bone");
    }

    public void shout(){
        System.out.println("Wang! Wang! Wang!");
    }

    public void watchDoor(){
        System.out.println("Gatekeeper");
    }
}

class Cat extends Animal{
    public void eat(){
        System.out.println("Cat eats fish");
    }

    public void shout(){
        System.out.println("Meow! Meow! Meow!");
    }
}

class Order{

    public void method(Object obj){

    }
}

class Driver {

    public void doData(Connection conn) {//conn = new MySQlConnection(); / conn = new OracleConnection();
        //规范的步骤去操作数据
//		conn.method1();
//		conn.method2();
//		conn.method3();

    }
}