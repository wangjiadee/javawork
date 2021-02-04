package com.ralph.java.Multithreading;
/**
 * Description: 介绍Thread中的常用方法
 * Class:
 * Author:     ralph
 **/
public class ThreadMethod {

    //1.start() :        启动当前的线程，调用当前线程的run()
    //2.run():           通常需要重写Thread类中的此方法，主要是执行的内容写在run()中
    //3.currentThread(): 静态方法 返回执行当前代码线程的
    //4.getName():       获取当前线程的名字
    //5.setName():       设置当前线程的名字
    //7.yield():         释放当前线程（切换线程）
    //8.join():          停止当前线程 切换其他线程执行换成之后 在继续执行
    //9.sleep():         延迟/睡眠指定时间后执行
    //iaAlive():         判断是否还存活


    public static void main(String[] args) {
        DefineNameThread defineNameThread = new DefineNameThread("ThreadFirst");
        defineNameThread.start();

        Thread.currentThread().setName("MainThread");

    }
}





class DefineNameThread extends Thread{
    @Override
    public void run() {
        for (int i=0;i < 100;i++){
            if (i %2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

            if (i%20 ==0){
                yield();
            }

        }
    }

    public DefineNameThread(String name){
        super(name);
    }
}

