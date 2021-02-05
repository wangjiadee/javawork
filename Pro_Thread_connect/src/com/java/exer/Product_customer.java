package com.java.exer;



/**
 * @author ralph
 * @create 2021-01-30 21:50
 */
public class Product_customer {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer p1 = new Producer(clerk);
        p1.setName("[生产者：]");

        Consumer c1 = new Consumer(clerk);
        c1.setName("[消费者:");

        p1.start();
        c1.start();
    }
}


class Clerk{
    private int productnum = 0;

    public synchronized void pp() {
        if (productnum < 20){
            productnum++;
            System.out.println(Thread.currentThread().getName() + "开始生产第" + productnum + "产品");

            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void cp() {
        if (productnum > 0 ){
            System.out.println(Thread.currentThread().getName() + "开始消费第" + productnum + "产品");
            productnum--;

            notify();
        }else  {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread{
    private Clerk ck;

    public Producer(Clerk ck) {
        this.ck = ck;
    }

    @Override
    public void run() {
        System.out.println(getName()+"开始生产产品了喂！");

        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ck.pp();
        }

    }
}

class Consumer extends Thread{
    private Clerk ck;

    public Consumer(Clerk ck) {
        this.ck = ck;
    }

    @Override
    public void run() {
        System.out.println(getName()+"开始消费产品了喂！");

        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ck.cp();
        }

    }
}