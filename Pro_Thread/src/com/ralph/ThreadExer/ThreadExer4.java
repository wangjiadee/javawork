package com.ralph.ThreadExer;

public class ThreadExer4 {
    public static void main(String[] args) {
        MyThreadForR myThreadForR = new MyThreadForR();
        MyThreadForT myThreadForT = new MyThreadForT();
        Thread t1 = new Thread(myThreadForR);
        Thread t2 = new Thread(myThreadForT);

        t1.start();
        t2.start();

    }
}


class MyThreadForT extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("This is Thread " + Thread.currentThread().getName() + " Method!");
    }
}

class MyThreadForR implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("This is Runnable " + Thread.currentThread().getName() + " Method!");
    }
}