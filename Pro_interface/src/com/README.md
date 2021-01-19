接口(interface)是抽象方法和常量值定义的集合。 

JDK7及以前：只能定义全局常量和抽象方法

- ​	全局常量：public static final的.但是书写时，可以省略不写

```java
	public static final int MAX_SPEED = 7900;//第一宇宙速度
	int MIN_SPEED = 1;//省略了public static final
```

抽象方法：public abstract的

JDK8：除了定义全局常量和抽象方法之外，还可以定义静态方法、默认方法（略）

```java
	public abstract void fly();
	//省略了public abstract
	void stop();
```



*接口中不能定义构造器的！意味着接口不可以实例化*（抽象类 可以有构造器，单不能实例化）

* Java开发中，接口通过让类去实现(implements)的方式来使用.
* 如果实现类覆盖了接口中的所有抽象方法，则此实现类就可以实例化
* 如果实现类没有覆盖接口中所有的抽象方法，则此实现类仍为一个抽象类

```
子类重写父类的正常方法 叫做重写
子类重写父类的抽象方法和接口 叫做实现
非抽象类叫重写   抽象类和接口叫实现
```



java类可以实现多个接口 ---> 弥补了java单继承性的局限性

```java
class AA extends BB implement CC,DD,EE
```



接口与接口之间可以继承，而且可以多集成

```
interface AA{
    void method1();
}

interface BB{
    void method2();
}

interface CC extends AA,BB{

}

```



