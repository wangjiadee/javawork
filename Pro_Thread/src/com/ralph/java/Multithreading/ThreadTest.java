package com.ralph.java.Multithreading;
/**
 * Description:  多线程的创建  另一个线程 输出2的倍数
 * Class:      1.常见一个类来继承Thread的类
 * Author:     ralph
 **/
class MyThread extends Thread{
    /**
     * Description: 重写run方法  ---> 线程要做的事情 声明在run方法中

     * return
     * Author:     ralph
     **/
    @Override
    public void run() {
        for (int i = 0;i < 100;i++){
            if(i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}

/**
 * Description: 主线程 首先做了子类的创建和start的调用 然后输出3的倍数
 * Class:
 * Author:     ralph
 **/
public class ThreadTest {
    public static void main(String[] args) {
        //3.创建thread类的子类对象
        MyThread myThread = new MyThread();
        MyThread myThread2 = new MyThread();

        //4.通过此对象来调用start(); 自动的去调用run方法 开始执行线程任务
        myThread.start();
        //如果需要启动多个线程 需要在new一个对象 一个start只能启动一个线程
        myThread2.start();

        //如下的操作还是在main线程中
        for (int i = 0;i < 100;i++){
            if(i % 3 == 0){
                System.out.println(i + "*******main()**********");
            }
        }
    }
}