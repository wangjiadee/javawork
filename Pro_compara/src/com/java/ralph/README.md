#### Java比较器

导入：Java中的对象，正常情况下，只能进行比较：==  或  != 。不能使用 > 或 < 的
但是在开发场景中，我们需要对多个对象进行排序，言外之意，就需要比较对象的大小。
如何实现？使用两个接口中的任何一个：Comparable 或 Comparator



```
Java实现对象排序的方式有两种： 
 自然排序：java.lang.Comparable 
 定制排序：java.util.Comparator
```

###### 自然排序：java.lang.Comparable

Comparable接口强行对实现它的每个类的对象进行整体排序。这种排序被称为类的自然排序，实现 Comparable 的类`必须实现 compareTo(Object obj) `方法，两个对象即 通过 compareTo(Object obj) 方法的返回值来比较大小。如果当前对象this大 于形参对象obj，则返回正整数，如果当前对象this小于形参对象obj，则返回 负整数，如果当前对象this等于形参对象obj，则返回零。 

- String：按照字符串中字符的Unicode值进行比较
- Character：按照字符的Unicode值来进行比较 
- 数值类型对应的包装类以及BigInteger、BigDecimal：按照它们对应的数值 大小进行比较 
- Boolean：true 对应的包装类实例大于 false 对应的包装类实例
- Date、Time等：后面的日期时间比前面的日期时间



1.像String、包装类等实现了Comparable接口，重写了compareTo(obj)方法，给出了比较两个对象大小的方式。
2.像String、包装类重写compareTo()方法以后，进行了从小到大的排列

```java
        String[] arr = new String[]{"AA","CC","KK","MM","GG","JJ","DD"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        //[AA, CC, DD, GG, JJ, KK, MM]
```

3. 重写compareTo(obj)的规则：
    如果当前对象this大于形参对象obj，则返回正整数，
    如果当前对象this小于形参对象obj，则返回负整数，
    如果当前对象this等于形参对象obj，则返回零。
    
    
    
4. 对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable接口，重写compareTo(obj)方法。
   在compareTo(obj)方法中指明如何排序

```java
    @Override
    public int compareTo(Object o) {
//        System.out.println("**************");
        if(o instanceof Goods){
            Goods goods = (Goods)o;
            //方式一：
            if(this.price > goods.price){
                return 1;
            }else if(this.price < goods.price){
                return -1;
            }else{
//                return 0;
               return -this.name.compareTo(goods.name);
            }
            //方式二：
//           return Double.compare(this.price,goods.price);
        }
//        return 0;
        throw new RuntimeException("传入的数据类型不一致！");
    }
```

###### 定制排序：java.util.Comparator

1.背景：
当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码，或者实现了java.lang.Comparable接口的排序规则不适合当前的操作，那么可以考虑使用 Comparator 的对象来排序

2.重写`compare(Object o1,Object o2)`方法，比较o1和o2的大小：如果方法返回正整数，则表示o1大于o2；如果返回0，表示相等；返回负整数，表示o1小于o2。

```java
public void test3(){
        String[] arr = new String[]{"AA","CC","KK","MM","GG","JJ","DD"};
        Arrays.sort(arr,new Comparator(){

            //按照字符串从大到小的顺序排列
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof String && o2 instanceof  String){
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }
//                return 0;
                throw new RuntimeException("输入的数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }
```

两种排序方式的对比：

```
 Comparable接口的方式一旦确定，保证Comparable接口实现类的对象在任何位置都可以比较大小。
 Comparator接口属于临时性的比较。
```

