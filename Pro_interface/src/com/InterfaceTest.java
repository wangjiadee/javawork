package com;

public class InterfaceTest {
    public static void main(String[] args) {
        System.out.println(Flyable.MAX_SPEED);
        System.out.println(Flyable.MIN_SPEED);

        Plane p = new Plane();
        p.fly();
        p.stop();

        Kite k = new Kite() {
            @Override
            public void stop() {
                System.out.println("Fucking too");
            }
        };

        k.stop();

    }
}

interface Flyable{
    public static final int MAX_SPEED = 7999;
    int MIN_SPEED = 1;

    public abstract void fly();
    void stop();

}

interface Attackable{
    void attack();
}

class Plane implements Flyable{
    @Override
    public void fly() {
        System.out.println("fucking fly");
    }

    @Override
    public void stop() {
        System.out.println("fucking stop");
    }
}



abstract class Kite implements Flyable{
    @Override
    public void fly() {
        System.out.println("Fucking fly too");
    }
}


class Bullet implements Flyable,Attackable,CC{
    @Override
    public void fly() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void attack() {

    }

    @Override
    public void method2() {

    }

    @Override
    public void method1() {

    }
}


interface AA{
    void method1();
}

interface BB{
    void method2();
}

interface CC extends AA,BB{

}
