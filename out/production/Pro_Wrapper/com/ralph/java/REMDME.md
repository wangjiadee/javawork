#### 包装类

将基本数据类型包装成类 ，具有类的特征



| 基本数据类型 |    包装类     |
| :----------: | :-----------: |
|     byte     |     Byte      |
|    short     |     Short     |
|   **int**    |  **Integer**  |
|     long     |     Long      |
|    float     |     Float     |
|    double    |    Double     |
|   boolean    |    Boolean    |
|   **char**   | **Character** |



基本数据类型、包装类、string三者之间的转换

1.基本数据类型 ----> 包装类

```
        int num1 = 10;
        Integer in1 = new Integer(num1);
```



2.包装类----->基本数据类型

```
        Integer in1 = new Integer(12);
        int i1 = in1.intValue();
        System.out.println(i1 + 1);
```



3.包装类 ---> String类型 valueOf

```
        float f1 = 12.3f;
        String str2 = String.valueOf(f1);
```



4String类型 --->基本数据类型、包装类：调用包装类的parseXxx(String s)

```

```





自动装箱和自动拆箱

```
自动装箱： 基本数据---> 包装类
        int num2 = 122;
        Integer in1 = num2;

        boolean b1 = true;
        Boolean b2 = b1;

```



```
自动拆箱：包装类---> 基本数据类
        System.out.println(in1.toString());
        int num3 = in1;
```



缓存概念

```java
public void test3() {
    Integer i = new Integer(1);
    Integer j = new Integer(1);
    System.out.println(i == j);//false

    //Integer内部定义了IntegerCache结构，IntegerCache中定义了Integer[],
    //保存了从-128~127范围的整数。如果我们使用自动装箱的方式，给Integer赋值的范围在
    //-128~127范围内时，可以直接使用数组中的元素，不用再去new了。目的：提高效率

    Integer m = 1;
    Integer n = 1;
    System.out.println(m == n);//true

    Integer x = 128;//相当于new了一个Integer对象
    Integer y = 128;//相当于new了一个Integer对象
    System.out.println(x == y);//false
```