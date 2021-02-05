package com.ralph.java;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ralph
 * @create 2021-01-30 15:21
 */
public class LockTest {
    public static void main(String[] args) {
        Window w = new Window();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("W1:");
        t2.setName("W2:");
        t3.setName("W3:");

        t1.start();
        t2.start();
        t3.start();

    }
}


class Window implements Runnable{

    private int ticket = 100;

    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true){
            try {
                lock.lock();

                if (ticket > 0){

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + ticket);
                    ticket--;
                }else {
                    break;
                }
            } finally {
                lock.unlock();

            }
        }
    }
}