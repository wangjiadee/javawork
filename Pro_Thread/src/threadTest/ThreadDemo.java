package threadTest;



public class ThreadDemo {
    public static void main(String[] args) {
        Mythread1 mythread1 = new Mythread1();
        Mythread2 mythread2 = new Mythread2();

        mythread2.setPriority(Thread.MIN_PRIORITY);

        mythread1.start();
        mythread2.start();



    }
}


class Mythread1 extends Thread{
    @Override
    public void run() {
        for (int i =0;i <100;i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + i );
            }

        }
    }
}


class Mythread2 extends Thread{
    @Override
    public void run() {
        for (int i =0;i <100;i++){
            if(i % 3 == 0){
                System.out.println(Thread.currentThread().getName() + ":"+ Thread.currentThread().getPriority()+ i );
            }
        }

    }
}