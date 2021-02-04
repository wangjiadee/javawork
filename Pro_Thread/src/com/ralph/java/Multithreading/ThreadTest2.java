package com.ralph.java.Multithreading;
/**
 * Description:
 *     //1.创建一个实现了runnable的接口类
 *     //2. 实现类去实现runnable中的抽象方法 run
 *     //3.创建实现类的对象
 *     //4.将此对象作为参数传递导Thread类的构造器中，创建Thread类的对象
 *     //5.通过Thread类的对象调用start()
 * Class:
 * Author:     ralph
 **/
public class ThreadTest2 {
    public static void main(String[] args) {
        //3.创建实现类的对象
        MThread mThread = new MThread();
        //4.将此对象作为参数传递导Thread类的构造器中，创建Thread类的对象
        Thread t1 = new Thread(mThread);
        Thread t2 = new Thread(mThread);
        //5.通过Thread类的对象调用start()
        t1.setName("Fuck-thread1");
        t1.start();
        t2.setName("Fuck-thread2");
        t2.start();

    }



}

/**
 * Description: 创建一个实现了runnable的接口类
 * Class:
 * Author:     ralph
 **/
class MThread implements Runnable{

    //2. 实现类去实现runnable中的抽象方法 run
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            if (i %2 ==0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}