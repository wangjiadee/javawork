package com.ralph.java;
import java.util.Date;
public class ToStringTest {
    public static void main(String[] args) {
        Customer cut1 = new Customer("TOM",21);
        System.out.println(cut1.toString());
        System.out.println(cut1);

        String str = new String("FF");
        System.out.printf("str");

        Date date = new Date(4534534534543L);
        System.out.println(date.toString());
    }



}
