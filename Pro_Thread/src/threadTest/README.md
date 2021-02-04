#### 程序

```
静态代码 为了完成特定的任务 用于某种语言来编写
```

#### 进程

```
跑起来的程序 具有生命周期
```

#### 线程

```
线程是进一步的线程 一个进程内部的一条执行路径（单线程 /多线程）
具有一个虚拟机栈 和程序计数器pc
```

并行和并发

```
并行： 多个人同时做不同事
并发： 多个人同是做同一件事情
```





创建线程的问题：

```
1.不能直接调用run()来启动其他的线程
```





Thread：常用的方法

```
    //1.start() :        启动当前的线程，调用当前线程的run()
    //2.run():           通常需要重写Thread类中的此方法，主要是执行的内容写在run()中
    //3.currentThread(): 静态方法 返回执行当前代码线程的
    //4.getName():       获取当前线程的名字
    //5.setName():       设置当前线程的名字
    //7.yield():         释放当前线程（切换线程）
    //8.join():          停止当前线程 切换其他线程执行换成之后 在继续执行
    //9.sleep():         延迟/睡眠指定时间后执行
    //iaAlive():         判断是否还存活

```



线程可以设置优先级

```
max 10  
min 1
norm 5
--------------------------------
高优先级的线程抢占低优先级CPU的执行权限，只是从概率上讲 高优先级的线程高概率情况下被执行

```



```
//实现Runnable接口的方式（开发中使用）
天然支持共享数据

//继承Thread类的方式（继承在继承中具有局限性 开发中不使用）
不支持天然共享数据  需要配置static静态信息


相同： 2个都需要重写run()方式
```



#### 线程的生命周期

JDK中用Thread.State类定义了线程的几种状态

要想实现多线程，必须在主线程中创建新的线程对象。Java语言使用Thread类 及其子类的对象来表示线程，在它的一个完整的生命周期中通常要经历如下的`五种状态`： 

- 新建： 当一个Thread类或其子类的对象被声明并创建时，新生的线程对象处于新建 状态
- 就绪：处于新建状态的线程被start()后，将进入线程队列等待CPU时间片，此时它已 具备了运行的条件，只是没分配到CPU资源 
- 运行：当就绪的线程被调度并获得CPU资源时,便进入运行状态， run()方法定义了线 程的操作和功能 
- 阻塞：在某种特殊情况下，被人为挂起或执行输入输出操作时，让出 CPU 并临时中 止自己的执行，进入阻塞状态 
- 死亡：线程完成了它的全部工作或线程被提前强制性地中止或出现异常导致结束





#### 线程的同步机制

作用：解决线程的安全问题

处理背景：某一个线程在执行，但是没有完成全操作时候。其他的线程参与进来。如银行有1W米，您在ATM机上取6K，于此同时，您老婆在手机银联取款6K，如果钱都能取出，银行血亏2K.

两种方式来解决：

1. 同步代码块

```java
synchronized(同步监视器){
       //需要被同步的代码
 	   //操作共享数据的代码 就是同步的代码
 }
```

同步监视器 俗称`锁`   使用要求 ：多个线程必须要共用同一把锁

接口实现的同步代码块

```java
class Window1 implements Runnable{
    private int ticket =100;

    @Override
    public void run() {
        while (true){
            synchronized (this){  //this 表示Window1 的实例化对象w 
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w =new Window1();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
```

继承Thread的同步代码块

```java
class Window2 extends Thread{
    private static int ticket = 100;
    private static Object obj = new Object(); //因为实例化类中实例化了3个类

    @Override
    public void run() {
        while(true){
            //正确的
            //synchronized (obj){
            synchronized (Window2.class){
                //Class clazz = Window2.class,Window2.class只会加载一次
                //错误的方式：this代表着t1,t2,t3三个对象


                if(ticket > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + "：卖票，票号为：" + ticket);
                    ticket--;
                }else{
                    break;
                }
            }
        }
    }
}


public class WindowTest2 {
    public static void main(String[] args) {
        Window2 t1 = new Window2();
        Window2 t2 = new Window2();
        Window2 t3 = new Window2();


        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}
```

2. 同步方法：（依旧继承同步监视器 但是不需要显示声明）

   ​	 如果操作共享数据的代码完整的声明在一个方法中，直接将此方法声明同步

   是实现Runnable类的方式实现同步方法

```java
class Window3 implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        while (true) {

            show();
        }
    }

    private synchronized void show(){//同步监视器：this
        //synchronized (this){

        if (ticket > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);

            ticket--;
        }
        //}
    }
}


public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w = new Window3();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

}
```

继承Thread的方式来同步方法

```java
class Window4 extends Thread {
    private static int ticket = 100;
    @Override
    public void run() {
        while (true) {
            show();
        }
    }
    private static synchronized void show(){//同步监视器：Window4.class
        //private synchronized void show(){ //同步监视器：t1,t2,t3。此种解决方式是错误的
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "：卖票，票号为：" + ticket);
            ticket--;
        }
    }
}

public class WindowTest4 {
    public static void main(String[] args) {
        Window4 t1 = new Window4();
        Window4 t2 = new Window4();
        Window4 t3 = new Window4();


        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
```



懒汉式的线程安全问题

```
class Bank{

    private Bank(){}

    private static Bank instance = null;

    public static synchronized Bank getInstance(){
            if (instance == null){
                synchronized (Bank.class){
                    if (instance == null){
                        instance = new Bank();
                    }
                }
            }
            return instance;
        
    }
}
```



线程池方式：

```java
class NumberThread implements Runnable{

    @Override
    public void run() {
        for(int i = 0;i <= 100;i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

class NumberThread1 implements Runnable{

    @Override
    public void run() {
        for(int i = 0;i <= 100;i++){
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

public class ThreadPool {

    public static void main(String[] args) {
        //1. 提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        //设置线程池的属性
//        System.out.println(service.getClass());
//        service1.setCorePoolSize(15);
//        service1.setKeepAliveTime();


        //2.执行指定的线程的操作。需要提供实现Runnable接口或Callable接口实现类的对象
        service.execute(new NumberThread());//适合适用于Runnable
        service.execute(new NumberThread1());//适合适用于Runnable

//        service.submit(Callable callable);//适合使用于Callable
        //3.关闭连接池
        service.shutdown();
    }

}
```

```java
* 面试题：sleep() 和 wait()的异同？
* 1.相同点：一旦执行方法，都可以使得当前的线程进入阻塞状态。
* 2.不同点：1）两个方法声明的位置不同：Thread类中声明sleep() , Object类中声明wait()
*          2）调用的要求不同：sleep()可以在任何需要的场景下调用。 wait()必须使用在同步代码块或同步方法中
*          3）关于是否释放同步监视器：如果两个方法都使用在同步代码块或同步方法中，sleep()不会释放锁，wait()会释放锁。
```

```
* 2. 面试题：synchronized 与 Lock的异同？
*   相同：二者都可以解决线程安全问题
*   不同：synchronized机制在执行完相应的同步代码以后，自动的释放同步监视器
*        Lock需要手动的启动同步（lock()，同时结束同步也需要手动的实现（unlock()）
```





4.
面试题：Java是如何解决线程安全问题的，有几种方式？并对比几种方式的不同


面试题：synchronized和Lock方式解决线程安全问题的对比