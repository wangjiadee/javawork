#### 向下转型

```
Man m1 = (Man)p2;
```

对于类的转向：

子类------（向上转型）多态-------父类

子类------（向下转型）-------------父类



使用强转时，可能出现ClassCastException

为了防止以上问题的出现 可以使用`instaceof`

```
a instanceof A
判断对象a是否是类A的实列 
是返回ture 进行向下转型  [类A 是类a的父类]
不是返回false 不进行向下转型
```



编译时通过，运行时不通过

```
        Person p3 = new Woman();
        Man m3 = (Man)p3;
        
        Person p4 = new Person();
        Man m4 = (Man)p4;
```

编译通过，运行时也通过

```
        Object obj = new Woman();
        Person p = (Person)obj;
```

编译就不通过

```
Man m5 = new Woman();
```

