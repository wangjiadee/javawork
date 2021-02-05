package com.ralph.java;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ralph
 * @create 2021-01-30 15:57
 */
public class AccountTestForR {
    public static void main(String[] args) {
        Account1 acct1 = new Account1(0);
        Customer1 cust1 = new Customer1(acct1);

        Thread t1 = new Thread(cust1);
        Thread t2 = new Thread(cust1);

        t1.setName("Fuck");
        t1.setName("Boy");

        t1.start();
        t2.start();




    }
}

class Account1{
    private double balance1;

    private ReentrantLock lock = new ReentrantLock(true);

    public Account1(double balance1) {
        this.balance1 = balance1;
    }


    public void deposit1(double amt1){

        try {
            lock.lock();
            if (amt1 > 0){
                balance1 += amt1;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + ": save money success :" + balance1);
            }
        } finally {
            lock.unlock();
        }



    }
}

class Customer1 implements Runnable{
    private Account1 acct1;

    public Customer1(Account1 acct1) {
        this.acct1 = acct1;
    }

    @Override
    public void run() {
        for (int i =0;i<3;i++){
            acct1.deposit1(1000);
        }
    }
}


