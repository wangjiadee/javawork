package com.ralph.ThreadExer;

public class ThreadExer3 extends Thread {
    int k = 1;

    @Override
    public void run() {
        int i = k;
        while (i < 50){
                System.out.println("[" + Thread.currentThread().getName() + "]: " + i);
                i += 2;
        }
        System.out.println("[" + Thread.currentThread().getName() + "]:Finish!");
    }

    public static void main(String[] args) {
        ThreadExer3 t1 = new ThreadExer3();
        ThreadExer3 t2 = new ThreadExer3();
        t1.k = 1;
        t2.k = 2;
        t1.start();
        t2.start();
    }
}
