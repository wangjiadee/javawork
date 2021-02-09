package com.ralph.Exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class MyExerTest {

    /**
     * Description: 定义一个Collection接口类型的变量，引用一个Set集合的实现类，
     * 实现添加单个元素，添加另一个集合，删除元素，判断集合中是否包含一个元素，判断是否为空，清除集合，返回集合里元素的个数等常用操作
     * <p>
     * return
     * Author:     ralph
     **/
    @Test
    public void Test1() {
        HashSet<Object> setT1 = new HashSet<>();
        HashSet<Object> setT2 = new HashSet<>();
        //实现添加单个元素
        setT1.add("A");
        setT1.add("B");
        setT2.add("C");
        setT2.add("D");
        System.out.println(setT1);
        //添加另一个集合
        setT1.addAll(setT2);
        System.out.println(setT1);
        //删除元素
        setT1.remove("D");
        System.out.println(setT1);
        //判断集合中是否包含一个元素
        System.out.println(setT1.contains("D"));
        //判断是否为空
        System.out.println(setT1.isEmpty());
        //清除集合
        setT2.clear();
        //返回集合里元素的个数等常用操作
        System.out.println(setT2.size());


    }


    /**
     * Description:创建Set接口的实现类，添加10个以上的元素，通过Iterator遍历此集合元素。通过foreach遍历此集合元素。
     * <p>
     * return
     * Author:     ralph
     **/
    @Test
    public void Test2() {
        HashSet<Object> set1 = new HashSet<>();
        set1.add("123");
        set1.add("312");
        set1.add("321");
        set1.add("345");
        set1.add("543");
        set1.add("456");
        set1.add("654");
        set1.add("678");
        set1.add("876");
        set1.add("asd");
        //通过Iterator遍历此集合元素
        Iterator i1 = set1.iterator();
        while (i1.hasNext()) {
            System.out.println(i1.next());
        }
        //通过foreach遍历此集合元素
        for (Object obj : set1) {
            System.out.println(obj);
        }


    }


    @Test
    public void Test3() {
        HashSet<Object> se2 = new HashSet<>();
        se2.add(new MMP(19, "mdzz"));
        se2.add(new MMP(20, "mdSB"));
        se2.add(new MMP(30, "DM"));
        se2.add(new MMP(45, "DM"));
        se2.add(new MMP(65, "md"));
        se2.add(new MMP(65, "WDNMD"));

        Iterator i = se2.iterator();
        while (i.hasNext()) {
            Object o = i.next();
            System.out.println(o.toString());
        }

    }

    /**
     * Description: 创建Car类，包含name，price属性，构造器等方法，创建测试类，在main方法中创建Set接口的实现类，
     * 添加5个以上的Car对象，遍历集合元素，验证重复元素是否过滤了；如果没有过滤，实现过滤功能；
     * 把每个小车的price降10000元，再遍历，查看price是否已改变

     * return
     * Author:     ralph
     **/
    @Test
    public void Test4(){

        HashSet<Object> li = new HashSet<>();
        li.add(new Car("BYD",119000));
        li.add(new Car("WLHG",19000));
        li.add(new Car("AD",199000));
        li.add(new Car("TSL",156000));
        li.add(new Car("TSL",156000));


        Iterator iterator1 =li.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

    }

    /**
     * Description:创建ArrayList实例化对象，添加10个以上的元素，在2号位插入一个元素，获得5号位元素，删除6号位元素，修改7号位的元素；
     * 通过四种方法遍历上题中的集合

     * return
     * Author:     ralph
     **/
    @Test
    public void Test5(){
        ArrayList<Object> list1 = new ArrayList<>();
        list1.add("123");
        list1.add("321");
        list1.add("534");
        list1.add("345");
        list1.add("567");
        list1.add("765");
        list1.add("789");
        list1.add("fsd");
        list1.add("zds");
        list1.add("fgh");
        list1.add("123");
        list1.add(1,"eee");
        System.out.println(list1);
        System.out.println(list1.get(4));
        list1.remove(5);
        list1.set(6,"AAA");
        System.out.println(list1);


        Iterator iterator = list1.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("***************");

        //方式二：foreach循环
        for(Object obj : list1){
            System.out.println(obj);
        }

        System.out.println("***************");

        //方式三：普通for循环
        for(int i = 0;i < list1.size();i++){
            System.out.println(list1.get(i));
        }


    }


    /**
     * Description:创建LinkedList实例化对象，练习具有队列特点的方法

     * return
     * Author:     ralph
     **/
    @Test
    public void Test6(){
        Q q = new Q();
        boolean b = q.isEmpty();
        System.out.println(b);

        q.put("Fuck");
        q.put("Fuck u");
        q.put("Fuck u every day");

        b = q.isEmpty();
        System.out.println(b);
        q.show();

        q.get();
        q.show();




    }
}

class MMP implements Comparable{
    private int age;
    private String name;

    public MMP() {
    }

    public MMP(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MMP{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof MMP){
            MMP mmp = (MMP)o;
//            return -this.name.compareTo(user.name);
            int compare = Integer.compare(this.age,mmp.age);
            if(compare != 0){
                return compare;
            }else{
                return this.name.compareTo(mmp.name);
            }
        }else{
            throw new RuntimeException("输入的类型不匹配");
        }

    }
}


class Car{
    private String CarName;
    private int CarPrice;

    public Car() {
    }

    public Car(String carName, int carPrice) {
        CarName = carName;
        CarPrice = carPrice;
    }

    public String getCarName() {
        return CarName;
    }

    public void setCarName(String carName) {
        CarName = carName;
    }

    public int getCarPrice() {
        return CarPrice;
    }

    public void setCarPrice(int carPrice) {
        CarPrice = carPrice;
    }

    @Override
    public String toString() {
        return "Car{" +
                "CarName='" + CarName + '\'' +
                ", CarPrice=" + CarPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (CarPrice != car.CarPrice) return false;
        return CarName.equals(car.CarName);
    }

    @Override
    public int hashCode() {
        int result = CarName.hashCode();
        result = 31 * result + CarPrice;
        return result;
    }
}

class Q{
    private LinkedList list = new LinkedList();

    public void put(Object obj) {
        list.addLast(obj);
    }

    public Object get() {
        return list.removeFirst();
    }

    public boolean isEmpty() {
        boolean b = true;

        if(list.size()>0) {
            b = false;
        }

        return b;
    }

    public void show() {
        System.out.println(list);
    }
}