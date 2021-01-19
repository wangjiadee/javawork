#### 单例设计模式

1.所谓类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例



饿汉式单例模式

```java
public class 饿汉式 {
    public static void main(String[] args) {
        Bank  b1 =  Bank.getInstance();
        Bank  b2 =  Bank.getInstance();
        System.out.println(b1 == b2);

    }
}


class Bank{
//    构造私有化类的构造器
    private Bank(){

    }

//    私有化的内部对象 ---- 声明的对象 必须是静态的
    private static Bank instance = new Bank();

//    提供方法 得到对象
    public static Bank getInstance(){
        return instance;
    }
}
```





懒汉式：

```java
public class 懒汉式 {
    public static void main(String[] args) {
        Order o1 = Order.getInstance();
        Order o2 = Order.getInstance();

        System.out.println(o1 == o2);
    }


}
//懒汉式
class Order{
    //私有化类的构造器
    private Order(){

    }

    //声明当前类的对象，没有初始化 也是static
    private static Order instance = null;

    //
    public static Order getInstance(){
        if(instance == null){
            instance = new Order();
        }
        return instance;
    }
}
```

区分饿汉式 和 懒汉式

饿汉式： 

​	好处： 线程安全

​	坏处： 对象加载时间过长

懒汉式：	

​	好处：延迟对象的创建

​	害处：线程不安全

