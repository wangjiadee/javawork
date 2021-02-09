#### 枚举类

1.当需要定义一组常量时，强烈建议使用枚举类

```
定义：枚举类的理解：类的对象只有有限个，确定的。我们称此类为枚举类（若枚举只有一个对象, 则可以作为一种单例模式的实现方式.）
```

2.枚举类的属性 

- 枚举类对象的属性不应允许被改动, 所以应该使用 private final 修饰 
- 枚举类的使用 private final 修饰的属性应该在构造器中为其赋值 
- 若枚举类显式的定义了带参数的构造器, 则在列出枚举值时也必须对应的传入参数

3.枚举类定义的方法：

- 1.私有化类的构造器，保证不能在类的外部创建其对象 
  2.在类的内部创建枚举类的实例。声明为：public static final 
  3.对象如果有实例变量，应该声明为private final，并在构造器中初始化

```java
class Season{//老方式的定义
    //1.声明Season对象的属性:private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //2.私有化类的构造器,并给对象属性赋值
    private Season(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //3.提供当前枚举类的多个对象：public static final的
    public static final Season SPRING = new Season("春天","春暖花开");
    public static final Season SUMMER = new Season("夏天","夏日炎炎");
    public static final Season AUTUMN = new Season("秋天","秋高气爽");
    public static final Season WINTER = new Season("冬天","冰天雪地");

    //4.其他诉求1：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
    //4.其他诉求1：提供toString()
    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}

class Season{
    //1.声明Season对象的属性:private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //2.私有化类的构造器,并给对象属性赋值
    private Season(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //3.提供当前枚举类的多个对象：public static final的
    public static final Season SPRING = new Season("春天","春暖花开");
    public static final Season SUMMER = new Season("夏天","夏日炎炎");
    public static final Season AUTUMN = new Season("秋天","秋高气爽");
    public static final Season WINTER = new Season("冬天","冰天雪地");

    //4.其他诉求1：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
    //4.其他诉求1：提供toString()
    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
```

###### 使用enum关键字定义枚举类

定义的枚举类默认继承于java.lang.Enum类

```java
/*
1. 先提供枚举类的对象，用逗号隔开
2. 声明属性 */


public enum SeasonEnum {
	SPRING("春天","春风又绿江南岸"), 
    SUMMER("夏天","映日荷花别样红"), 
    AUTUMN("秋天","秋水共长天一色"), 
    WINTER("冬天","窗含西岭千秋雪");

    private final String seasonName; 
    private final String seasonDesc; 
    private SeasonEnum(String seasonName, String seasonDesc) { 
        this.seasonName = seasonName; 
        this.seasonDesc = seasonDesc; } 
    public String getSeasonName() { 
        return seasonName; } 
    public String getSeasonDesc() { 
        return seasonDesc; }
}
```

#### Enum类的主要方法

- values()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有的 枚举值。 
- valueOf(String str)：可以把一个字符串转为对应的枚举类对象。要求字符 串必须是枚举类对象的“名字”。如不是，会有运行时异常： IllegalArgumentException。 
- toString()：返回当前枚举类对象常量的名称

```java
 Season1 summer = Season1.SUMMER;
        //toString():返回枚举类对象的名称
        System.out.println(summer.toString());

//        System.out.println(Season1.class.getSuperclass());
        System.out.println("****************");
        //values():返回所有的枚举类对象构成的数组
        Season1[] values = Season1.values();
        for(int i = 0;i < values.length;i++){
            System.out.println(values[i]);
            values[i].show();
        }
        System.out.println("****************");
        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);
        }

        //valueOf(String objName):返回枚举类中对象名是objName的对象。
        Season1 winter = Season1.valueOf("WINTER");
        //如果没有objName的枚举类对象，则抛异常：IllegalArgumentException
//        Season1 winter = Season1.valueOf("WINTER1");
        System.out.println(winter);
//枚举类实现接口
        winter.show();

//使用enum定义枚举类之后，如何让枚举类对象分别实现接口：
interface Info{
    void show();
}

//使用enum关键字枚举类
enum Season1 implements Info{
    //1.提供当前枚举类的对象，多个对象之间用","隔开，末尾对象";"结束
    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里？");
        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("宁夏");
        }
    },
    AUTUMN("秋天","秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    WINTER("冬天","冰天雪地"){
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };

```

- 和普通 Java 类一样，枚举类可以实现一个或多个接口
  若每个枚举值在调用实现的接口方法呈现相同的行为方式，则只 要统一实现该方法即可。
  若需要每个枚举值在调用实现的接口方法呈现出不同的行为方式, 则可以让每个枚举值分别来实现该方法





#### 注解

-  注解(Annotation)概述 

  1.Annotation 可以像修饰符一样被使用, 可用于修饰包,类, 构造器, 方 法, 成员变量, 参数, 局部变量的声明, 这些信息被保存在Annotation 的 “name=value” 对中。

  2.Annotation 其实就是代码里的特殊标记, 这些标记可以在编译, 类加 载, 运行时被读取, 并执行相应的处理。通过使用Annotation, 程序员 可以在不改变原有逻辑的情况下, 在源文件中嵌入一些补充信息。代 码分析工具、开发工具和部署工具可以通过这些补充信息进行验证 或者进行部署。

  3.框架 = 注解 + 反射 + 设计模式

  

-  常见的Annotation示例 

  1.使用 Annotation 时要在其前面增加 @ 符号, 并把该 Annotation 当成 一个修饰符使用。用于修饰它支持的程序元素 

  ```
  @author 标明开发该类模块的作者，多个作者之间使用,分割 
  @version 标明该类模块的版本 @see 参考转向，也就是相关主题 
  @since 从哪个版本开始增加的 @param 对方法中某参数的说明，如果没有参数就不能写 
  @return 对方法返回值的说明，如果方法的返回值类型是void就不能写 
  @exception 对方法可能抛出的异常进行说明 ，如果方法没有用throws显式抛出的异常就不能写 
  其中 
  @param @return 和 @exception 这三个标记都是只用于方法的。
  @param的格式要求：@param 形参名 形参类型 形参说明 
  @return 的格式要求：@return 返回值类型 返回值说明 
  @exception的格式要求：@exception 异常类型 异常说明 
  @param和@exception可以并列多个
  ```

  ```java
   /* @author shkstart
   * @create 2019 上午 11:37
   */
  ```

  在编译时进行格式检查(JDK内置的三个基本注解)

  ```java
   /* @Override: 限定重写父类方法, 该注解只能用于方法
    * @Deprecated: 用于表示所修饰的元素(类, 方法等)已过时。通常是因为
    * 所修饰的结构危险或存在更好的选择
    * @SuppressWarnings: 抑制编译器警告
    /
    
  public class AnnotationTest{
  	public static void main(String[] args) { 
  		@SuppressWarnings("unused") 
  		int a = 10; } 
  	@Deprecated 
  	public void print(){
      	System.out.println("过时的方法"); 
      	}
  	@Override public String toString() {
      	return "重写的toString方法()"; 
      	}
  }
  ```

-  自定义Annotation 

   定义新的 Annotation 类型使用 @interface 关键字 
   自定义注解自动继承了java.lang.annotation.Annotation接口 
   Annotation 的成员变量在 Annotation 定义中以无参数方法的形式来声明。其 方法名和返回值定义了该成员的名字和类型。我们称为配置参数。类型只能 是八种基本数据类型、String类型、Class类型、enum类型、Annotation类型、 以上所有类型的数组。 
   可以在定义 Annotation 的成员变量时为其指定初始值, 指定成员变量的初始 值可使用 default 关键字 
   如果只有一个参数成员，建议使用参数名为value  如果定义的注解含有配置参数，那么使用时必须指定参数值，除非它有默认 值。格式是“参数名 = 参数值”，如果只有一个参数成员，且名称为value， 可以省略“value=” 

   没有成员定义的 Annotation 称为标记; 包含成员变量的 Annotation 称为元数 据 Annotation 
  注意：自定义注解必须配上注解的信息处理流程才有意义

  

  ```
  @MyAnnotation(value="abc")
  class Person{}
  ```

-  JDK中的元注解 

  JDK 的元Annotation 用于修饰其他Annotation 定义

  JDK5.0提供了4个标准的meta-annotation类型，分别是： 
      Retention 
      Target 
      Documented 
      Inherited
      
  元数据的理解： String name 就是元数据
  String name = “atguigu”;

  ```
  @Retention: 只能用于修饰一个 Annotation 定义, 用于指定该 Annotation 的生命周期, @Rentention 包含一个 RetentionPolicy 类型的成员变量, 使用@Rentention 时必须为该 value 成员变量指定值:  
  	1.RetentionPolicy.SOURCE:在源文件中有效（即源文件保留），编译器直接丢弃这种策略的注释
  	2.RetentionPolicy.CLASS:在class文件中有效（即class保留） ， 当运行 Java 程序时, JVM 不会保留注解。 这是默认值
  	3.RetentionPolicy.RUNTIME:在运行时有效（即运行时保留），当运行 Java 程序时, JVM 会 保留注释。程序可以通过反射获取该注释
  	
      
  ```

     ![image-20210205100618533](C:\Users\80288284\AppData\Roaming\Typora\typora-user-images\image-20210205100618533.png)

  ```java
  public enum RetentionPolicy{ 
  	SOURCE, 
  	CLASS, 
  	RUNTIME }
  
  @Retention(RetentionPolicy.SOURCE) @interface MyAnnotation1{  }
  @Retention(RetentionPolicy.RUNTIME) @interface MyAnnotation2{  }
  
  ```

  @Target: 用于修饰 Annotation 定义, 用于指定被修饰的 Annotation 能用于 修饰哪些程序元素。 @Target 也包含一个名为 value 的成员变量。

  

  @Documented: 用于指定被该元 Annotation 修饰的 Annotation 类将被 javadoc 工具提取成文档。默认情况下，javadoc是不包括注解的。 定义为Documented的注解必须设置Retention值为RUNTIME。

  

  @Inherited: 被它修饰的 Annotation 将具有继承性。如果某个类使用了被 @Inherited 修饰的 Annotation, 则其子类将自动具有该注解。 比如：如果把标有@Inherited注解的自定义的注解标注在类级别上，子类则可以 继承父类类级别的注解 实际应用中，使用较少

  

-  利用反射获取注解信息（在反射部分涉及） 

-  JDK 8中注解的新特

