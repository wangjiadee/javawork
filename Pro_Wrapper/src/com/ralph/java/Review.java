package com.ralph.java;

import org.junit.Test;

public class Review {
    @Test
    public void test2(){
        String s = "mdzz";
        s = null;
        System.out.println(s);
        System.out.println(s.toString());
    }

    @Test
    public void test1(){
        int[] arr = new int[]{1,2,3};
        print(arr); // inpurt Memory address [I@46f5f779
        System.out.println(arr.getClass());
    }

    public void print(Object obj){
        System.out.println(obj);
    }
}
