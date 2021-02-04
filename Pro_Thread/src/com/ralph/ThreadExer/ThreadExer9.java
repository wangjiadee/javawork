package com.ralph.ThreadExer;

public class ThreadExer9 {
    public static void main(String[] args) {
        Repository repository =new Repository();

        Producer1 producer1 = new Producer1(repository);
        Consumer1 consumer1 = new Consumer1(repository);

        producer1.setName("生产者");
        consumer1.setName("消费者");

        producer1.start();
        consumer1.start();
    }
}




class Repository{
    //仓库容量，初始为0，最大为4
    public static final int MAX_OPACITY=4;
    private int opacity=0;

    /**
     * 消费,当容量等于4时暂停生产
     */
    public void producer(){
        //容量未满时，生产,且通知消费者
        while (true) {
            synchronized (this) {
                if (opacity < MAX_OPACITY) {
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    opacity++;
                    System.out.println(Thread.currentThread().getName()+":生产产品第" + opacity + "个产品");
                    this.notifyAll();
                } else {
                    //容量满了，等待
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 消费，只能在容量>0时消费，容量等于0时等待
     */
    public void consumer(){
        while (true){
            synchronized (this) {
                if(opacity>0){
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName()+":消费了第"+opacity+"个产品");
                    opacity--;
                    this.notifyAll();
                }
                else {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}

class Producer1 extends Thread{
    private Repository repository;

    public Producer1(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void run() {
        repository.producer();
    }
}

class Consumer1 extends Thread{
    private Repository repository;

    public Consumer1(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void run() {
        repository.consumer();
    }
}