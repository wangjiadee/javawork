package com.ralph.ThreadExer;



class SimpleThread extends Thread {
    public int id,st;
    public  SimpleThread(String str)
    {
        super(str);
        if(str.equals("rabbit!!!"))
        {
            id=3;st=30;//兔子的话,速度id,休息时间为st~(st+50)
        }
        else
        {
            id=2;st=20;//乌龟的话,速度id,休息时间为st~(st+50)
        }
    }
    public void run()
    {
        int i;
        for(i=0;i<10;i+=id)
            System.out.println(i+" "+getName());
        if(i<10)
        {
            try
            {
                sleep(st+(((int)Math.random()*1000))%50);
            }
            catch (InterruptedException e){}
        }
        System.out.println(getName()+" "+"Reach!!!");
    }
};

public class ThreadExer6 {
    int id;
    public static void main(String args[])
    {
        new SimpleThread("rabbit!!!").start();
        new SimpleThread("tortoise!!!").start();
    }
}