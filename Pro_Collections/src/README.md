####  Collections工具类{ 就类似于操作数组的工具类 Arrays}



- Collections 是一个操作 Set、List 和 Map 等集合的工具类 

- Collections 中提供了一系列静态的方法对集合元素进行排序、查询和修改等操作， 还提供了对集合对象设置不可变、对集合对象实现同步控制等方法 

- 排序操作：（均为static方法） 

  + reverse(List)：反转 List 中元素的顺序 

    ```java
    List list = new ArrayList();
            list.add(123);
            list.add(43);
            list.add(765);
            list.add(765);
            list.add(765);
            list.add(-97);
            System.out.println(list);
            Collections.reverse(list);
    ```

    

  + shuffle(List)：对 List 集合元素进行随机排序 

    ```java
    Collections.shuffle(list);
    ```

    

  + sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序 

    ```
    Collections.sort(list);
    ```

    

  + sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序 

    ```
    Collections.swap(list,1,2);
    ```

    

  + swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换

  + Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素 

  + Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回 给定集合中的最大元素 

  + Object min(Collection) 

  + Object min(Collection，Comparator)

  + int frequency(Collection，Object)：返回指定集合中指定元素的出现次数 

    ```java
            int frequency = Collections.frequency(list, 123);
    
            System.out.println(list);
            System.out.println(frequency);
    ```

    

  + void copy(List dest,List src)：将src中的内容复制到dest中 

    ```java
            //报异常：IndexOutOfBoundsException("Source does not fit in dest")
            //        List dest = new ArrayList();
            //        Collections.copy(dest,list);
            //正确的：
            List dest = Arrays.asList(new Object[list.size()]);
            System.out.println(dest.size());//list.size();
            Collections.copy(dest,list);
    
            System.out.println(dest);
    
    ```

    

  + boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换 List 对象的所有旧值

  

Collections 类中提供了多个 synchronizedXxx() 方法，该方法可使将指定集合包装成线程同步的集合，从而可以解决多线程并发访问集合时的线程安全问题

```java
 //返回的list1即为线程安全的List
 List list1 = Collections.synchronizedList(list);
```



Collection 和 Collections的区别

```
1. Collection 是java中集合的上层接口，有2个主要的子集List 和Set
2. Collections 和Arrays 一样，是一种工具类，提供静态方法来实现对各种集合的操作
```



