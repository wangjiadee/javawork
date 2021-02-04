#### java中有几种方法可以实现一个线程{在jdk5.0之前}？用什么关键字修饰同步方法？stop()和suspend()方法为何不推荐使用？

```
有2种方式 分别是继承Thread类与实现Runnable接口，使用synchronized关键字修饰同步方法 
stop()方法不用的原因：它会解除由线程获取的所有的锁定
suspend()方法不用的原因：suspend()方法容易发生死锁
```

#### sleep() 和 wait() 有什么区别?    wait()、notify()、notifyAll()的作用分别是什么？

```
相同点： 都可以让线程处于堵塞状态
不同点：
sleep()处于继承Thread类的方法 可以让线程暂停指定的时间，然后自动恢复，不会释放对象锁
wait()是Object类的方法  线程可以直接放弃对象锁，进入等待，只有对应的notify方法(notifyAll)可以重新进入运行状态

notify() 唤醒随机线程
notify()唤醒所有线程
```

#### 同步和异步有何区别 在什么情况下用？

```
如果数据共享的情况下 应该是使用同步
如果程序调用了一个方法 要等待长时间的返回值 就开始使用异步了
```

#### 启动一个线程是run() 还是start()？

```
启动一个线程是start()方法 表示改线程处于可运行状态 但是不代表线程就立马执行了
run()方法就是正常的对象调用方法的执行，并不是使用分线程来执行的。
```

#### 当一个线程进入一个对象的一个synchronized方法后，其它线程是否可进入此对象的其它方法?

```
不能，一个对象的一个synchronized方法只能由一个线程访问
```

#### 请说出你所知道的线程同步的方法

```
1.wait() 使一个线程处于等待的状态 并且释放所持有的对象的lock
2.sleep() 使用一个正在运行的线程处于睡眠状态
3.notify() 唤醒一个处于wait()状态的线程 [不能指定线程 随机唤醒]
4.notifyAll() 唤醒所有处于等待的线程 
```

#### 多线程有几种实现方法,都是什么?同步有几种实现方法,都是什么? 

```
4种方式 来实现多线程池
1. 继承Thread类  2.实现Runnable接口 3.实现callrable接口  4.使用线程池

同步由2种实现方式
1.synchronized  2.wait 和 notify的组合
```

#### 在多线程中，为什么要引入同步机制?

```
怕2个像线程 同时对同一个资源进行操作；例如 A和B同时取1000米 A在ATM机上取钱 B在手机终端取钱，如果账号中只有1000米，没有同步机制的话，AB=两人都拿到钱，银行血亏
```

#### 线程的基本概念、状态和状态之间的关系

```
1.线程是指进程中的一种执行单位，每一个进程都至少有一个线程
2.具有创建、就绪、运行、堵塞、结束 5个状态
```

#### 简述synchronized和java.util.concurrent.locks.Lock的异同 ？

```
相同点：都可以完成同步的所有功能
不同点： lock更加灵活控制，锁是认为控制，unlock必须写在finnaly当中，但是synchronized是自己释放锁
```

#### Java为什么要引入线程机制，线程、程序、进程之间的关系是怎样的。

```
引入线程机制 是为了更好的去做并发处理
程序：静态的代码
进程：跑起来（执行静态的代码）的程序
线程：进程执行的1中单位方式
```

#### Runnable接口包括哪些抽象方法？Thread类有哪些主要域和方法？

```
Runnable接口中仅有run()抽象方法。
Thread类主要域有：MAX_PRIORITY,MIN_PRIORITY,NORM_PRIORITY。
	主要方法有start(),run(),sleep(),currentThread(),setPriority(),getPriority(),join()等。
```

#### 创建线程有哪两种方式(jdk5.0之前)？试写出每种的具体的流程。比较两种创建方式的不同，哪个更优？

```
1—继承Thread类
1)  定义类继承Thread类。
2)  覆盖Thread类中的run方法。
3)  创建Thread子类对象，即创建了线程对象。
4)  调用线程对象start方法：启动线程，调用run方法。

2—实现Runnable接口
1）定义类，实现Runnable接口。
2）覆盖Runnable接口中的run方法。
3）通过Thread类建立线程对象。
4）将Runnable接口的子类对象作为实际参数传递给Thread类的构造方法中。
5）调用Thread类的start方法：开启线程，调用Runnable子类接口的run方法。

【区别】
继承Thread: 线程代码存放Thread子类run方法中。
实现Runnable：线程代码存在接口的子类的run方法。

【实现方法的好处】
1）避免了单继承的局限性
2）多个线程可以共享同一个接口子类的对象，非常适合多个相同线程来处理同一份资源。
```

![](C:\Users\80288284\Desktop\MulThread.png)

#### 三个线程间的通讯

```java
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
```

#### 多线程的练习题目

```java
/*
编写一个继承Thread类的方式实现多线程的程序。该类MyThread有两个属性，一个字符串WhoAmI代表线程名，一个整数delay代表该线程随机要休眠的时间。构造有参的构造器，线程执行时，显示线程名和要休眠时间。
另外，定义一个测试类TestThread，创建三个线程对象以展示执行情况。
*/

class MyThread extends Thread{
    private String WhoAmI;
    private int delay;

    public MyThread(String whoAmI, int delay) {
        WhoAmI = whoAmI;
        this.delay = delay;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Fucking Hi! This is " + WhoAmI + " and I sleeping " + delay);
    }
}


public class ThreadExer2 {
    public static void main(String[] args) {
        MyThread m1 = new MyThread("Fucker1",(int) (Math.random() * 100));
        MyThread m2 = new MyThread("Fucker2",(int) (Math.random() * 100));
        MyThread m3 = new MyThread("Fucker3",(int) (Math.random() * 100));
        m1.start();
        m2.start();
        m3.start();

    }
}
```

```java
/*
利用多线程设计一个程序，同时输出 50 以内的奇数和偶数，以及当前运行的线程名。
*/

public class ThreadExer3 extends Thread {
    int k = 1;

    @Override
    public void run() {
        int i = k;
        while (i < 50){
                System.out.println("[" + Thread.currentThread().getName() + "]: " + i);
                i += 2;
        }
        System.out.println("[" + Thread.currentThread().getName() + "]:Finish!");
    }

    public static void main(String[] args) {
        ThreadExer3 t1 = new ThreadExer3();
        ThreadExer3 t2 = new ThreadExer3();
        t1.k = 1;
        t2.k = 2;
        t1.start();
        t2.start();
    }
}
```



```java
/*
定义两个线程（一个用继承Thread类，一个用实现Runnable接口），定义一个测试类包括一个主函数调用两个子线程（具体实现自定）
*/

public class ThreadExer4 {
    public static void main(String[] args) {
        MyThreadForR myThreadForR = new MyThreadForR();
        MyThreadForT myThreadForT = new MyThreadForT();
        Thread t1 = new Thread(myThreadForR);
        Thread t2 = new Thread(myThreadForT);

        t1.start();
        t2.start();

    }
}


class MyThreadForT extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("This is Thread " + Thread.currentThread().getName() + " Method!");
    }
}

class MyThreadForR implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("This is Runnable " + Thread.currentThread().getName() + " Method!");
    }
}
```



```java
/*模拟一个人生产50个玩具，每200毫秒生产一个，当生产到第20个时加入每秒吃1个馒头，共吃完3个后在接着生产的多线程。*/
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
```



```java
/*实现一个由A、B、C三个窗口同时销售100张票的系统，要求打印出每个窗口打印的售票情况，并且每个窗口不得连续售票。 */
public class ThreadExer7 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        A a = new A(ticket);
        B b = new B(ticket);
        C c = new C(ticket);

        Thread thread1 = new Thread(a);
        Thread thread2 = new Thread(b);
        Thread thread3 = new Thread(c);

        thread1.setName("窗口A");
        thread2.setName("窗口B");
        thread3.setName("窗口C");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Ticket {
    int tickets = 0;
    int flag = 1;

    public synchronized void sellA() {
        if (flag != 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag = 2;
        if (tickets < 100) {
            System.out.println(Thread.currentThread().getName() + "售票，票号为：" + (++tickets));
        }
        notifyAll();
    }
    public synchronized void sellB() {
        if (flag != 2) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag = 3;
        if (tickets < 100) {
            System.out.println(Thread.currentThread().getName() + "售票，票号为：" + (++tickets));
        }
        notifyAll();

    }
    public synchronized void sellC() {
        if (flag != 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag = 1;
        if (tickets < 100) {
            System.out.println(Thread.currentThread().getName() + "售票，票号为：" + (++tickets));
        }
        notifyAll();
    }
}

class A implements Runnable {
    Ticket ticket;

    public A(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public void run() {
        while (ticket.tickets < 100) {
            ticket.sellA();
        }
    }
}

class B implements Runnable{
    Ticket ticket;

    public B(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public void run() {
        while (ticket.tickets < 100) {
            ticket.sellB();
        }
    }
}

class C implements Runnable{
    Ticket ticket;

    public C(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public void run() {
        while (ticket.tickets < 100) {
            ticket.sellC();
        }
    }
}
```



```java
/*模拟3个人排除买票，每人买1张票。售货员只有1张五元的钱，电影票5元一张，王大拿拿一张二十元的人民币排在谢大脚前面买票，谢大脚拿1张十元的人民币排在在赵四的前面买票，赵四拿1张五元的人民币排在最后。即最终的卖票次序是：谢大脚、赵四、王大拿*/

public class Practice {
    public static void main(String[] args) {
        TicketSeller seller = new TicketSeller();

        TicketThread t1= new TicketThread(seller, 5);
        TicketThread t2= new TicketThread(seller, 10);
        TicketThread t3= new TicketThread(seller, 20);

        t1.setName("赵四");
        t2.setName("谢大脚");
        t3.setName("王大拿");

        t3.start();
        t2.start();
        t1.start();

    }
}

/**
 * 买票线程，创建3个，模拟三人买票
 */
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

/**
 * 售票员，模拟售票可能遇到的3种情况
 */
class TicketSeller {
    private int fiveAcount = 1, tenAcount = 0, twentyAcount = 0;

    public synchronized void buyTicket(int receiveMoney) {
        //收到5元
        if (receiveMoney == 5) {
            System.out.println(Thread.currentThread().getName()+"付钱5元，不用找钱");
            fiveAcount++;
        }
        //收到10元
        else if(receiveMoney== 10){
            //没有5元现金，需要让10元客户等待，
            while (fiveAcount<1){
                System.out.println(Thread.currentThread().getName()+"付钱10元，现在没有零钱，请等待");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //有5元零钱，进行操作
            System.out.println(Thread.currentThread().getName()+"付了10元"+"找给"+Thread.currentThread().getName()+"5元");
            fiveAcount--;
            tenAcount++;
        }
        //收到20元
        else {
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
```



```java
/*编写生产者消费者多线程程序，设有一个最大库存量为4的电视机仓库，生产10台电视机，一边生产一边销售（消费）*/
public class Practice {
    public static void main(String[] args) {
        Repository repository =new Repository();

        Producer1 producer1 = new Producer1(repository);
        Consumer1 consumer1 = new Consumer1(repository);

        producer1.setName("生产者");
        consumer1.setName("消费者");

        producer1.start();
        consumer1.start();
    }
}

class Repository{
    //仓库容量，初始为0，最大为4
    public static final int MAX_OPACITY=4;
    private int opacity=0;

    /**
     * 消费,当容量等于4时暂停生产
     */
    public void producer(){
        //容量未满时，生产,且通知消费者
        while (true) {
            synchronized (this) {
                if (opacity < MAX_OPACITY) {
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    opacity++;
                    System.out.println(Thread.currentThread().getName()+":生产产品第" + opacity + "个产品");
                    this.notifyAll();
                } else {
                    //容量满了，等待
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 消费，只能在容量>0时消费，容量等于0时等待
     */
    public void consumer(){
        while (true){
            synchronized (this) {
                if(opacity>0){
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName()+":消费了第"+opacity+"个产品");
                    opacity--;
                    this.notifyAll();
                }
                else {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}

class Producer1 extends Thread{
    private Repository repository;

    public Producer1(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void run() {
        repository.producer();
    }
}

class Consumer1 extends Thread{
    private Repository repository;

    public Consumer1(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void run() {
        repository.consumer();
    }
}
```



#### 面试可能会巴巴的问题

- java是多线程语言

- 线程死亡，不再运行

- 在 Java 中，高优先级的可运行线程会抢占低优先级线程。（用setPrority方法可以改变线程的优先级，线程通过yield方法    可以使具有相同优先级线程获得处理器）

- Java 提供了一个系统线程来管理内存的分配 Java 语言中提供了一个垃圾收集线程，自动回收动态分配的内存。

- 一个线程在调用它的 start 方法，之前，该线程将一直处于出生期。

- 如果线程的 run 方法执行结束或抛出一个不能捕获的例外，线程便进入死亡状态。

- 线程通过sleep方法可以休眠一段时间，然后恢复运行

- notify方法使对象等待队列的第一个线程进入就绪状态

- 一个线程被用 suspend( )方法，将该线程挂起。并通过调用 resume( )方法来重新开始线程的执行。但是该方法容易导致死    锁，应尽量避免使用。

- sleep wait suspend方法可以用来暂时停止当前线程的运行