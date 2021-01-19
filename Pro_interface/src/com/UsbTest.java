package com;

public class UsbTest {
    public static void main(String[] args) {
        Computer com = new Computer();

        //创建了接口的 非匿名实现类 的 非匿名对象
        Flash f = new Flash();
        com.transferData(f);

        // 创建了接口的 非匿名实现类 的 匿名对象
        com.transferData(new Printer());

        //创建了接口的 匿名实现类 的 非匿名对象
        USB phone = new USB() {
            @Override
            public void start() {
                System.out.println("phone begin worked!");
            }

            @Override
            public void stop() {
                System.out.println("phone finished worked!");
            }
        };

        com.transferData(phone);


        //创建了接口的 匿名实现类 的 匿名对象
        com.transferData(new USB() {
            @Override
            public void start() {
                System.out.println("MP3 begin worked!");
            }

            @Override
            public void stop() {
                System.out.println("MP3 finished worked");
            }
        });
    }
}

class Computer{
    public void transferData(USB u ){
        u.start();
        System.out.println("=====>working<=====");
        u.stop();
    }
}



interface USB{
    void start();
    void stop();
}


class Flash implements USB{
    @Override
    public void start() {
        System.out.println("USB began worked!");
    }

    @Override
    public void stop() {
        System.out.println("USB finished worked!");
    }
}

class Printer implements USB{
    @Override
    public void start() {
        System.out.println("Printer began worked!");
    }

    @Override
    public void stop() {
        System.out.println("Printer finished worked!");
    }
}