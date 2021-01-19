package com.Proxy.module;

public class ProxyTest {
    public static void main(String[] args) {
        Proxy p = new Proxy(new RealStar());
        p.bookTicket();
        p.sing();
    }

}


interface Star{
    void confer();

    void signContract();

    void bookTicket();

    void sing();

    void collectMoney();
}

class RealStar implements Star{
    public void confer() {
    }

    public void signContract() {
    }

    public void bookTicket() {
    }

    public void sing() {
        System.out.println("Realstart: singing");
    }

    public void collectMoney() {
    }
}


class Proxy implements Star {
    private Star real;

    public Proxy(Star real) {
        this.real = real;
    }

    public void confer() {
        System.out.println("broker talking");
    }

    public void signContract() {
        System.out.println("The broker signs the contract");
    }

    public void bookTicket() {
        System.out.println("Broker booking");
    }

    public void sing() {
        real.sing();
    }

    public void collectMoney() {
        System.out.println("Broker collects money");
    }
}
