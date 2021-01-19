#### Object类中toString的使用

1.当我们输出一个对象的引用时候，实际上就是调用当前对象的toString()

2.Object类中toString()的定义：

```
public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
     }
```

不一定全部的都是输出地址值

```
        String str = new String("FF");
        System.out.printf("str");
```

因为要考虑重写的问题

3.像String、Date、File、包装类等都重写了Object类中的toString()方法，使得在调用对象的toString()时，返回“实体内容”信息

4.自定义类也可以重写toString()方法，当前调用此方法时，返回对象的“实体内容”





