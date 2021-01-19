package com.interf.exer;

public class ComparableCircleTest {
    public static void main(String[] args) {
        ComparableCircle c1 = new ComparableCircle(3.4);
        ComparableCircle c2 = new ComparableCircle(3.9);

        int compareValue = c1.compareTo(c2);
        if (compareValue > 0){
            System.out.println("C1 Max");
        }else if(compareValue < 0){
            System.out.println("C2 Max");
        }else {
            System.out.println("as like");
        }
    }
}
