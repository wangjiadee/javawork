#### java集合

1. 集合与数组存储数据概述：
集合、数组都是对多个数据进行存储操作的结构，简称Java容器。
说明：此时的存储，主要指的是内存层面的存储，不涉及到持久化的存储（.txt,.jpg,.avi，数据库中)
2. 数组存储的特点：

> 一旦初始化以后，其长度就确定了。
> 数组一旦定义好，其元素的类型也就确定了。我们也就只能操作指定类型的数据了。
>
> *       比如：String[] arr;int[] arr1;Object[] arr2;
3. 数组存储的弊端：
*      > 一旦初始化以后，其长度就不可修改。
*      > 数组中提供的方法非常限，对于添加、删除、插入数据等操作，非常不便，同时效率不高。
*      > 获取数组中实际元素的个数的需求，数组没有现成的属性或方法可用
*      > 数组存储数据的特点：有序、可重复。对于无序、不可重复的需求，不能满足。



Java 集合可分为 Collection 和 Map 两种体系

- Collection接口：单列数据，定义了存取一组对象的方法的集合
  		List：元素有序、可重复的集合
  		Set：元素无序、不可重复的集合
- Map接口：双列数据，保存具有映射关系“key-value对”的集合

```
|----Collection接口：单列集合，用来存储一个一个的对象
*          |----List接口：存储序的、可重复的数据。  -->“动态”数组
*              |----ArrayList、LinkedList、Vector
*
*          |----Set接口：存储无序的、不可重复的数据   -->高中讲的“集合”
*              |----HashSet、LinkedHashSet、TreeSet
===============================================================================================
|----Map:双列数据，存储key-value对的数据   ---类似于高中的函数：y = f(x)
*       |----HashMap:作为Map的主要实现类；线程不安全的，效率高；存储null的key和value
*              |----LinkedHashMap:保证在遍历map元素时，可以照添加的顺序实现遍历。
*                    原因：在原的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素。
*                    对于频繁的遍历操作，此类执行效率高于HashMap。
*       |----TreeMap:保证照添加的key-value对进行排序，实现排序遍历。此时考虑key的自然排序或定制排序
*                      底层使用红黑树
*       |----Hashtable:作为古老的实现类；线程安全的，效率低；不能存储null的key和value
*              |----Properties:常用来处理配置文件。key和value都是String类型
*
*
*      HashMap的底层：数组+链表  （jdk7及之前)
*                    数组+链表+红黑树 （jdk 8)
```



#### Collection接口

1.Collection 接口是 List、Set 和 Queue 接口的父接口，该接口里定义的方法既可用于操作 Set 集合，也可用于操作 List 和 Queue 集合。

2.JDK不提供此接口的任何直接实现，而是提供更具体的子接口(如：Set和List)
实现。

`向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals().`

Collection 方法：

```java
/*
添加
add(Object obj)：添加一个到一个集合里面
addAll(Collection coll)： 添加一个集合到集合里面
*/      

        Collection coll = new ArrayList();
        Collection coll1 = new ArrayList();
        coll1.add(123);
        coll.add(123);
        coll.add(123);
        coll.add(123);
        coll.add(123);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);
        System.out.println(coll.size()); //7
        coll.addAll(coll1);
        System.out.println(coll.size()); //8

/*
获取有效元素的个数  int size() 
*/
		System.out.println(coll.size());

/*清空集合  void clear() */
	    coll.clear();
        System.out.println(coll.size());

/*
是否包含某个元素 
boolean contains(Object obj)：是通过元素的equals方法来判断是否 是同一个对象
boolean containsAll(Collection c)：也是调用元素的equals方法来比 较的。拿两个集合的元素挨个比较。
*/
    Collection coll = new ArrayList();
    Collection coll1 = new ArrayList();
    coll1.add(123);
    coll.add(123);
    System.out.println(coll.contains(123));
    System.out.println(coll.containsAll(coll1));

/*
boolean remove(Object obj) ：通过元素的equals方法判断是否是 要删除的那个元素。只会删除找到的第一个元素 boolean removeAll(Collection coll)：取当前集合的差集 
*/
        coll.remove(123);
        System.out.println(coll);

	   coll.removeAll(coll1);
        System.out.println(coll);

/*
取两个集合的交集
boolean retainAll(Collection c)：把交集的结果存在当前集合中，不影响c 
*/
	    Collection coll2 = Arrays.asList(123,456,789);
        coll.retainAll(coll2);
        System.out.println(coll);

/* equals(Object obj):要想返回true，需要当前集合和形参集合的元素都相同。*/
        Collection coll2 = Arrays.asList(123,456,789);
        Collection coll3 = new  ArrayList();
        coll3.add(123);
        coll3.add(456);
        coll3.add(789);
        System.out.println(coll2.equals(coll3));

/* hashCode():返回当前对象的哈希值*/
		System.out.println(coll.hashCode());


/*集合 --->数组：toArray() */
        Object[] arr = coll2.toArray();
        for (int i =0;i <arr.length;i++){
        System.out.println(arr[i]);
            
            
/*遍历iterator()：返回迭代器对象，用于集合遍历*/
```

数组 --->集合:调用Arrays类的静态方法asList()

```java
        System.out.println("===数组 --->集合:调用Arrays类的静态方法asList()===");
        List<String> list = Arrays.asList(new String[]{"AA","bb","CC"});
        System.out.println(list);

        List arr1 = Arrays.asList(new int[]{123, 456}); //设置成int基础数据就会认为是一个 
        System.out.println(arr1.size());//1

        List arr2 = Arrays.asList(new Integer[]{123, 456});//设置成包装类 就是2个
        System.out.println(arr2.size());//2

```



#### iterator迭代器接口

1.Iterator对象称为迭代器(设计模式的一种)，主要用于遍历 Collection 集合中的元素

2.提供一种方法访问一个容器(container)对象中各个元 素，而又不需暴露该对象的内部细节。迭代器模式，就是为容器而生。

3.Iterator 仅用于遍历集合，`集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合 的第一个元素之前`

Iterator接口的方法

```
hasNext()
Returns true if the iteration has more elements.

next()
Returns the next element in the iteration.

remove()
Removes from the underlying collection the last element returned by this iterator (optional operation).
```

![image-20210205152350791](C:\Users\80288284\AppData\Roaming\Typora\typora-user-images\image-20210205152350791.png)

`在调用it.next()方法之前必须要调用it.hasNext()进行检测。若不调用，且 下一条记录无效，直接调用it.next()会抛出NoSuchElementException异常`

```java
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();

		//hasNext():判断是否还有下一个元素
        while(iterator.hasNext()){
            //next():①指针下移 ②将下移以后集合位置上的元素返回
            System.out.println(iterator.next());
        }
```

Iterator接口remove()方法