package com.ralph.ThreadExer;

public class ThreadExer {
    public static void main(String[] args) {
        MyTask myTask = new MyTask();

        new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        myTask.task1();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        myTask.task2();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }.start();
        new Thread(){

            @Override
            public void run() {
                while (true){
                    try {
                        myTask.task3();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

    }
}

class MyTask{
    int flag= 1;

    public synchronized void task1() throws InterruptedException{
        if (flag != 1){
            this.wait();
        }
        System.out.println("1.Drugged");
        flag =2;
        //this.notify(); 唤醒随机线程
        this.notifyAll(); // 唤醒所有等待的进程
    }

    public synchronized void task2() throws InterruptedException{
        if (flag != 2){
            this.wait();
        }
        System.out.println("2.Go to bed and push off pants");
        flag =3;
        //this.notify(); 唤醒随机线程
        this.notifyAll(); // 唤醒所有等待的进程
    }

    public synchronized void task3() throws InterruptedException{
        if (flag != 3){
            this.wait();
        }
        System.out.println("3.Fuck woman");
        flag =1;
        //this.notify(); 唤醒随机线程
        this.notifyAll(); // 唤醒所有等待的进程
    }


}