package com.ralph.ThreadExer;

class MyThread extends Thread{
    private String WhoAmI;
    private int delay;

    public MyThread(String whoAmI, int delay) {
        WhoAmI = whoAmI;
        this.delay = delay;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Fucking Hi! This is " + WhoAmI + " and I sleeping " + delay);
    }
}


public class ThreadExer2 {
    public static void main(String[] args) {
        MyThread m1 = new MyThread("Fucker1",(int) (Math.random() * 100));
        MyThread m2 = new MyThread("Fucker2",(int) (Math.random() * 100));
        MyThread m3 = new MyThread("Fucker3",(int) (Math.random() * 100));
        m1.start();
        m2.start();
        m3.start();

    }
}
