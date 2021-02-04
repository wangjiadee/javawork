package com.ralph.ThreadExer;

public class ThreadExer8 {
    public static void main(String[] args) {
        TicketSeller t1 = new TicketSeller();
        TicketThread t2 = new TicketThread(t1,5);
        TicketThread t3 = new TicketThread(t1,10);
        TicketThread t4 = new TicketThread(t1,20);

        t2.setName("赵四");
        t3.setName("谢大脚");
        t4.setName("王大拿");

        t2.start();
        t3.start();
        t4.start();


    }
}



class TicketThread extends Thread{
    private TicketSeller seller;
    private int money;

    public TicketThread(TicketSeller seller, int money) {
        this.seller = seller;
        this.money = money;
    }

    @Override
    public void run() {
        seller.buyTicket(money);
    }
}

class TicketSeller {
    private int fiveAcount = 1, tenAcount = 0, twentyAcount = 0;
    public synchronized void buyTicket(int receiveMoney) {
        //收到五块钱的情况
        if (receiveMoney == 5) {
            System.out.println(Thread.currentThread().getName()+"付钱5元，不用找钱");
            fiveAcount++;
        }
        //收到十块钱的情况
        else if (receiveMoney == 10){
            //如果没有钱找等待
            while (fiveAcount<1){
                System.out.println(Thread.currentThread().getName()+"付钱10元，现在没有零钱，请等待");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //有5块钱直接操作
            System.out.println(Thread.currentThread().getName()+"付了10元"+"找给"+Thread.currentThread().getName()+"5元");
            fiveAcount--;
            tenAcount++;

        }else{ //收到20元的情况
            //没有同时拥有5元和10元
            while (fiveAcount<1 || tenAcount<1){
                System.out.println(Thread.currentThread().getName()+"付钱20元，现在没有零钱，请等待");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //同时拥有5元和10元，可以给20元找零
            System.out.println(Thread.currentThread().getName()+"付了20元"+"找给"+Thread.currentThread().getName()+"15元");
            twentyAcount++;
            fiveAcount--;
            tenAcount--;

        }

        //卖票成功，通知其他人刷新状态，判断是否仍需等待。
        notifyAll();
    }


}