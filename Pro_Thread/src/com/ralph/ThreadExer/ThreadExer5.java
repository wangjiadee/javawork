package com.ralph.ThreadExer;



public class ThreadExer5 {
    public static void main(String[] args) {
        Toy t1 = new Toy();
        ToyWorker toyWorker1 = new ToyWorker(t1);
        toyWorker1.setName("玩具工人");

        EatManTou eatManTou1 = new EatManTou(t1);
        eatManTou1.setName("面包");

        toyWorker1.start();
        eatManTou1.start();

    }
}

class Toy{
    private int ToyCount = 0;
//    private int ManTouNUM = 0;

    //生产玩具
    public synchronized void produceToy(){

        if (ToyCount != 20){
            ToyCount++;
            System.out.println(Thread.currentThread().getName() +":开始生产第" + ToyCount + "个玩具" );
            notify();
        }else{
            //满了20个 要吃面包了
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void EatSteamedBread() {
        if (ToyCount == 20){
            for(int i =1; i < 4 ;i++){
                System.out.println(Thread.currentThread().getName() + ":开始吃第" + i + "个馒头");
            }

            notify();
            ToyCount++;

        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ToyWorker extends Thread{
    private Toy toy;

    public ToyWorker(Toy toy){
        this.toy = toy;
    }

    @Override
    public void run() {
        System.out.println(getName()+ "开始制造玩具");

        while (true){

            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            toy.produceToy();
        }
    }
}

class EatManTou extends Thread{

    private Toy toy;
    public EatManTou(Toy toy){
        this.toy = toy;
    }

    @Override
    public void run() {
        System.out.println(getName() + "玩具满了20 开始吃面包了喂");

        while (true){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            toy.EatSteamedBread();
        }
    }
}

