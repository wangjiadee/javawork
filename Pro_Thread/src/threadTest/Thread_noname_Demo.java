package threadTest;

public class Thread_noname_Demo {

    public static void main(String[] args) {
        //创建Thread匿名子类
        new Thread(){
            @Override
            public void run() {
                for (int i =0;i < 100;i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();


        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 3 == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();
    }
}
