#### final:最终的

1. final可以用来修饰的结构：类、方法、变量

2. final 用来修饰一个类:此类不能被其他类所继承。

   ​	比如：String类、System类、StringBuffer类

3. final 用来修饰方法：表明此方法不可以被重写

   ​	比如：Object类中getClass();

4. final 用来修饰变量：此时的"变量"就称为是一个常量

```java
//final修饰属性：可以考虑赋值的位置有：显式初始化、代码块中初始化、构造器中初始化
// 显式初始化
final int width = 0;


//代码块中初始化
    final int LEFT;
    {
        LEFT = 1;
    }

//构造器中初始化
    final int RLGHT;
    public FinalTest(){
        RLGHT = 2;
    }

```

5. final修饰局部变量：

   尤其是使用final修饰形参时，表明此形参是一个常量。当我们调用此方法时，给常量形参赋一个实参。一旦赋值以后，就只能在方法体内使用此形参，但不能进行重新赋值。

```java
static final 用来修饰属性：全局常量
```









