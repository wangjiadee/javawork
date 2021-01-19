package com.ralph.java;

public class mainDome {
    public static void main(String[] args) {
        for(int i = 0; i < args.length;i++){
            System.out.println(args[i]);

            int num = Integer.parseInt(args[i]);
            System.out.println(num);
        }
    }
}
