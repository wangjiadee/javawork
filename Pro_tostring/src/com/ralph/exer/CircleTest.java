package com.ralph.exer;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle1 = new Circle(2.3);
        Circle circle2 = new Circle(2.3,new String("w"),21);
        System.out.println("color question: "+ circle1.getColor().equals(circle2.getColor()));

        System.out.println("radius question: " + circle1.equals(circle2));

        System.out.println(circle1);
        System.out.println(circle2.toString());
    }
}
