package com.ralph.java.Multithreading;

/**
 * Description: 使用继承的方式来实现买票机制
 * Class:
 * Author:     ralph
 **/
class  Window extends Thread{

    private static int ticket = 100;
    Object obj = new Object();


    @Override
    public void run() {
        while (true){
            synchronized (obj) {
                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(getName() + ":save ticket" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }

    }
}

public class WindowTest {
    public static void main(String[] args) {
        Window window1 = new Window();

        Thread t1 = new Thread(window1);
        Thread t2 = new Thread(window1);
        Thread t3 = new Thread(window1);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}


