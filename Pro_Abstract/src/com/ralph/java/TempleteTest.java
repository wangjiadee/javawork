package com.ralph.java;

public class TempleteTest {
    public static void main(String[] args) {
        Subclass t = new Subclass();
        t.SepndTime();
    }
}


abstract class Father{

    public void SepndTime(){

        long start_time = System.currentTimeMillis();

        this.code();

        long end_time = System.currentTimeMillis();

        System.out.println("This code run time : " + (end_time - start_time));

    }

    public abstract void code();

}

class Subclass extends Father{

    @Override
    public void code(){
        for (int i =2;i <= 1000;i++){
            boolean isFlag = true;
            for (int j = 2;j <= Math.sqrt(i); j++){

                if (i % j == 0){
                    isFlag = false;
                    break;
                }
            }
            if (isFlag){
                System.out.println(i);
            }
        }
    }

}