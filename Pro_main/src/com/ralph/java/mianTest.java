package com.ralph.java;

public class mianTest {
    public static void main(String[] args) {
        Main.main(new String[100]);
        show();
    }

    public static void show(){

    }
}

class Main{
    public static void main(String[] args) {

        for (int i = 0;i < args.length;i++){
            args[i] = "opus_" + i;
            System.out.println(args[i]);
        }
    }
}