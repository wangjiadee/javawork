#### 抽象类

  1.abstract 抽象的

2. 可以修饰的结构： 类、方法 

abstract修饰类：抽象类

> 此类不能实例化

```java
public class AbstractTest {
    public static void main(String[] args) {
        Person p = new Person(); // error
        p.eat();
    }
}
abstract class Person{
    String name;
    int age;

    public void eat(){
        System.out.println("111");
    }

    public void show(){
        System.out.println("123");
    }
}
```

> 抽象类中一定有构造器，便于子类实例化时调用（涉及：子类对象实例化的全过程）

```java
abstract class Person{
    String name;
    int age;
    public Person(){

    }
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    public void eat(){
        System.out.println("111");
    }
    public void show(){
        System.out.println("123");
    }
}

class Student extends Person{
    public Student(String name,int age){
        super(name,age);
    }
}
```

> 开发中，都会提供抽象类的子类，让子类对象实例化，完成相关的操作

abstract修饰方法：抽象方法

> 抽象方法只有方法的声明，没有方法体

```java
//   不是抽象方法：
    public void show(){
    }
}
//   不是抽象方法：
    public abstract void show();
```

> 包含抽象方法的类，一定是一个抽象类。反之，抽象类中可以没有抽象方法的。

```java
abstract class Person{
    public abstract void show();
}
```

> 若子类重写了父类中的所有的抽象方法后，此子类方可实例化
> 若子类没有重写父类中的所有的抽象方法，则此子类也是一个抽象类，需要使用abstract修饰

```java
abstract class Person{}
abstract class Person extends Creature{}
```





使用的注意点：

abstract 不能修饰属性、构造器 、私有方法、静态方法、final的方法、final的类

```
Q：为什么抽象类不可以使用final关键字声明？
A：抽象类是需要子类来继承的，然而final是一个固定的不变的，无法继承

Q：一个抽象类中可以定义构造器吗？
A：可以 虽然抽象类中不可创建对象，但是可以定义构造器来给子类使用


```

