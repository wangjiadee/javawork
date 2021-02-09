#### Map接口

1.Map接口的大致框架

![img](/uploader/f/l0UNGx2DObqMc8u3.png)![image-20210207140925279](C:\Users\80288284\AppData\Roaming\Typora\typora-user-images\image-20210207140925279.png)

```
|----Map:双列数据，存储key-value对的数据   ---类似于高中的函数：y = f(x)
  |----HashMap:作为Map的主要实现类；线程不安全的，效率高；存储null的key和value
      |----LinkedHashMap:保证在遍历map元素时，可以按照添加的顺序实现遍历。
      原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素。对于频繁的遍历操作，此类执行效率高于HashMap。
  |----TreeMap:保证按照添加的key-value对进行排序，实现排序遍历。此时考虑key的自然排序或定制排序底层使用红黑树
  |----Hashtable:作为古老的实现类；线程安全的，效率低；不能存储null的key和value
      |----Properties:常用来处理配置文件。key和value都是String类型
```

2.Map接口概述

- Map与Collection并列存在。用于保存具有映射关系的数据:key-value 
- Map 中的 key 和 value 都可以是任何引用类型的数据 
- Map 中的 key 用Set来存放，不允许重复，即同一个Map对象所对应的类须重写hashCode()和equals()方法 
- 常用String类作为Map的“键” 
- key 和 value 之间存在单向一对一关系，即通过指定的 key 总能找到 唯一的、确定的 value 
- Map接口的常用实现类：HashMap、TreeMap、LinkedHashMap和 Properties。其中，`HashMap`是 Map 接口使用频率最高的实现类

3.Map的常用方法

```java
 //Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
        HashMap hashMap = new HashMap();
        hashMap.put("A",123);
        hashMap.put(null,123);
        System.out.println(hashMap);
//[Input] {null=123, A=123}

//void putAll(Map m):将m中的所有key-value对存放到当前map中
        HashMap hashMap2 = new HashMap();
        hashMap2.put("c",123);
        hashMap2.put("S",133);
        hashMap.putAll(hashMap2);
        System.out.println(hashMap);
//[Input]  {null=123, A=123, c=123, S=133}

// Object remove(Object key)：移除指定key的key-value对，并返回value
        System.out.println(hashMap.remove("A"));
        System.out.println(hashMap);
//[Input] 123
//[Input] {null=123, c=123, S=133}

//void clear()：清空当前map中的所有数据 
	    hashMap2.clear();
        System.out.println(hashMap2);
 
//Object get(Object key)：获取指定key对应的value 
		hashMap.get("c");
        System.out.println(hashMap.get("c"));

//boolean containsKey(Object key)：是否包含指定的key
//boolean containsValue(Object value)：是否包含指定的value 
        Map map = new HashMap();
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);
        //containsKey(Object key)
        boolean isExist = map.containsKey("BB");
        System.out.println(isExist);
	    isExist = map.containsValue(123);
        System.out.println(isExist);

//int size()：返回map中key-value对的个数 
		System.out.println(hashMap.size());

//boolean isEmpty()：判断当前map是否为空
		System.out.println(map.isEmpty());

//boolean equals(Object obj)：判断当前map和参数对象obj是否相等


/*
 元视图操作的方法:
  Set keySet()：返回所有key构成的Set集合 
  Collection values()：返回所有value构成的Collection集合 
  Set entrySet()：返回所有key-value对构成的Set集合
*/
        HashMap hashMap3 = new HashMap();
        hashMap3.put("A",321);
        hashMap3.put("b",321);
        hashMap3.put("K",321);
//遍历所有的key集：keySet()
        Set map = hashMap3.keySet();
        Iterator iterator = map.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
//遍历所有的value集：values()
        Collection values = hashMap3.values();
            for (Object obj  : values){
                System.out.println(obj);
            }
		//Set entrySet = hashMap3.entrySet();
        Iterator iterator2 = hashMap3.entrySet().iterator();
        while (iterator2.hasNext()){
            Object obj = iterator2.next();
            Map.Entry n =(Map.Entry)obj;
            System.out.println(n.getKey() +"----"+ n.getValue());
```

###### Map实现类之一：HashMap

- HashMap是 Map 接口使用频率最高的实现类。
- 允许使用null键和null值，与HashSet一样，不保证映射的顺序。
-  所有的key构成的集合是Set:无序的、不可重复的。所以key所在的类要重写： equals()和hashCode() 
- 一个key-value构成一个entry 
- 所有的entry构成的集合是Set:无序的、不可重复的 
- HashMap 判断两个 key 相等的标准是：两个 key 通过 equals() 方法返回 true， hashCode 值也相等。
- ashMap 判断两个 value相等的标准是：两个 value 通过 equals() 方法返回 true

1. HashMap的底层存储结构

   ```
   数组+链表  （jdk7及之前）
   数组+链表+红黑树 （jdk 8）
   ```

![image-20210207154154103](C:\Users\80288284\AppData\Roaming\Typora\typora-user-images\image-20210207154154103.png)

![image-20210207154226614](C:\Users\80288284\AppData\Roaming\Typora\typora-user-images\image-20210207154226614.png)

2.HashMap 底层源码理解：

jdk7：

```java
HashMap map = new HashMap(); //在实例化以后，底层创建了长度是16的一维数组Entry[] table。
map.put(key1,value1);
map.put(key2,value2);

//首先 抵用key1所在类的hashcode()计算key1哈希值，此哈希值经过某种算法计算以后，得到再Entry数组中的存放位置。如果此位置上的数据为空，那么key1,value1添加成功----情况1

//如果这个位置上的数据不为空（意味着此位置上存在一个或多个数据(以链表形式存在)）比较key1和已经存在的一个或多个数据的哈希值
	//如果key1的哈希值与已经存在的数据的哈希值都不相同，此时key2,value2添加成功。----情况2
	//如果key1的哈希值和已经存在的某一个数据(key2-value2)的哈希值相同，继续比较：
		//通过key1所在类的equals方法比较（key2）
		//如果equals()返回false:此时key1-value1添加成功。----情况3
		//如果equals()返回true:使用value1替换value2。
//情况2和情况3：此时key2-value2和原来的key1-value1数据以链表的方式存储。
```

jdk8：

```
1.相比jdk7，8没有再底层创建一个长度为16的数组
2.jdk8中不是Entry 而是Node node中有前后的索引
3.首次调用put()添加方法时候才再底层创建一个长度为16的数组
4.在生成链表结构的时候 （jdk7指向的是旧的元素 jdk8指向的是新的元素）“7上8下”
5.当数组的某一个索引位置上的元素以链表形式存在的数据个数 > 8 且当前数组的长度 > 64时，此时此索引位置上的所数据改为使用红黑树存储。

jdk8 注意的点：
DEFAULT_INITIAL_CAPACITY : HashMap的默认容量，16
DEFAULT_LOAD_FACTOR：HashMap的默认加载因子：0.75
threshold：扩容的临界值，=容量*填充因子：16 * 0.75 => 12 
TREEIFY_THRESHOLD：Bucket中链表长度大于该默认值，转化为红黑树:8
MIN_TREEIFY_CAPACITY：桶中的Node被树化时最小的hash表容量:64
```



```
注意点：
1. 什么是吞吐临界值？什么是负载因子( 或填充比)？默认大小是多少？
	容量*填充因子：16 * 0.75 => 12     这里的0.75 就是负载因子，它能控制HashMap的数据密度
	当一个Node数组[数组的默认大小是16]到达12个的时候 会进行扩容 扩容为原来的2倍
2.MashMap的底层原理？
    往上看
```

###### Map实现类之二：LinkedHashMap

- LinkedHashMap 是 HashMap 的子类
- 在HashMap存储结构的基础上，使用了一对双向链表来记录添加元素的顺序
- 与LinkedHashSet类似，LinkedHashMap 可以维护 Map 的迭代 顺序：迭代顺序与 Key-Value 对的插入顺序一致



HashMap中的内部类：Node：

```java
static class Node<K,V> implements Map.Entry<K,V> { 
        final int hash;
        final K key;
        V value; 
        Node<K,V> next; 
    }
```

LinkedHashMap中的内部类：Entry

```java
    static class Entry<K,V> extends HashMap.Node<K,V> { 
        Entry<K,V> before, after; 
        Entry(int hash, K key, V value, Node<K,V> next) {
            super(hash, key, value, next); 
        } 
    }
```

###### Map实现类之三：TreeMap 

- TreeMap存储 Key-Value 对时，需要根据 key-value 对进行排序。 TreeMap 可以保证所有的 Key-Value 对处于有序状态

- TreeSet底层使用红黑树结构存储数据 

- TreeMap 的 Key 的排序： 

  - 自然排序：TreeMap 的所有的 Key 必须实现 Comparable 接口，而且所有 的 Key 应该是同一个类的对象，否则将会抛出 ClassCastException

  ```java
  @Test
      public void Test1(){
          TreeMap map = new TreeMap();
          OPPO o1 = new OPPO("A1",1899);
          OPPO o2 = new OPPO("F2",5899);
          OPPO o3 = new OPPO("R1",6899);
          OPPO o4 = new OPPO("E4",899);
  
          map.put(o1,1);
          map.put(o2,2);
          map.put(o3,3);
          map.put(o4,4);
  
  
          Iterator i1 = map.entrySet().iterator();
          while (i1.hasNext()){
              Object obj = i1.next();
              Map.Entry entry = (Map.Entry)obj;
              System.out.println(entry.getKey() + "---" + entry.getValue());
          }
      }
  
  
  //============================OPPO====================================
   //省略 定义变量/构造器/get（）/set（）/toString/hashcode和equals的重写方法 都是idea自动生成
      
      @Override
      public int compareTo(Object o) {
          if (o instanceof OPPO){
              OPPO oppo = (OPPO)o;
              int compare = -this.name.compareTo(oppo.name);
              if(compare != 0){
                  return compare;
              }else{
                  return Integer.compare(this.price,oppo.price);
              }
          }else{
              throw new RuntimeException("输入的类型不匹配");
  
          }
      }
      
  ```

  

  - 定制排序：创建 TreeMap 时，传入一个 Comparator 对象，该对象负责对 TreeMap 中的所有 key 进行排序。此时不需要 Map 的 Key 实现 Comparable 接口 

    ```java
        public void Test2(){
            TreeMap m = new TreeMap(new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    if(o1 instanceof  OPPO && o2 instanceof OPPO) {
                        OPPO oppo1 = (OPPO) o1;
                        OPPO oppo2 = (OPPO) o2;
                        return Integer.compare(oppo1.getPrice(), oppo2.getPrice());
                    }
                    throw new RuntimeException("你看看你输入的都是啥");
                }
            });
        OPPO OP1 = new OPPO("f1",12333);
        OPPO OP2 = new OPPO("r5",544);
        OPPO OP3 = new OPPO("a11",3343);
        OPPO OP4 = new OPPO("e9",13);
    
        m.put(OP1,1);
        m.put(OP2,2);
        m.put(OP3,3);
        m.put(OP4,4);
    
        Iterator i1 =  m.entrySet().iterator();
        while (i1.hasNext()){
            Object obj = i1.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "===" + entry.getValue());
        }
    
        }
    ```

    

- TreeMap判断两个key相等的标准：两个key通过compareTo()方法或 者compare()方法返回0。



###### Map实现类之四：Hashtable



 Hashtable是个古老的 Map 实现类，JDK1.0就提供了。不同于HashMap， Hashtable是线程安全的。 
 Hashtable实现原理和HashMap相同，功能相同。底层都使用哈希表结构，查询 速度快，很多情况下可以互用。 
 与HashMap不同，Hashtable 不允许使用 null 作为 key 和 value 
 与HashMap一样，Hashtable 也不能保证其中 Key-Value 对的顺序 Hashtable判断两个key相等、两个value相等的标准，与HashMap一致



###### Map实现类之五：Properties 

1. Properties 类是 Hashtable 的子类，该对象用于处理属性文件 
2. 由于属性文件里的 key、value 都是字符串类型，所以 Properties 里的 key 和 value 都是字符串类型 
3. 存取数据时，建议使用setProperty(String key,String value)方法和 getProperty(String key)方法

```java
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            Properties pros = new Properties();
            fis = new FileInputStream("jdbc.properties");
            pros.load(fis); //加载流对应的文件

            String Username = pros.getProperty("Username");
            String Password = pros.getProperty("Password");
            System.out.println("N: " + Username + "P :" +Password);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null){
                try {
                    fis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

```

