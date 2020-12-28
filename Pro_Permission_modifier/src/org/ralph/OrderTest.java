package org.ralph;

public class OrderTest {
    public static void main(String[] args) {
        Order o = new Order();

        o.orderPublic =1;
        o.orderProtected =2;
        o.orderDefault =3;
        o.methodDsfault();
        o.methodProtected();
        o.methodPublic();
    }
}
