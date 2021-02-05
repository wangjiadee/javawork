package com.ralph.java;

import java.util.TreeMap;

/**
 * @author ralph
 * @create 2021-01-30 21:09
 */
public class Connect {
    public static void main(String[] args) {
        Number num = new Number();
        Thread t1 = new Thread(num);
        Thread t2 = new Thread(num);

        t1.setName("[P1]");
        t2.setName("[P2]");

        t1.start();
        t2.start();
    }

}


class Number implements Runnable{
    private int number = 1;

    @Override
    public void run() {

        while (true){

            synchronized (this){
                notify();

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (number <= 100){
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;
                }else {
                    break;
                }

                try {
                    //使得进程堵塞
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}