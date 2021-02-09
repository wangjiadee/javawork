package com.ralph.java;

import org.junit.Test;

import java.util.*;

public class CollMethodTest {
    @Test
    public void Test1(){
        Collection coll = new ArrayList();
        Collection coll1 = new ArrayList();
        coll1.add(123);
        coll1.add(789);
        coll.add(123);
        coll.add(789);
        coll.add(123);
        coll.add(123);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);
        System.out.println(coll.size());
        coll.addAll(coll1);
        System.out.println(coll.size());
        System.out.println(coll.contains(123));
        System.out.println(coll.containsAll(coll1));

        coll.remove(123);
        System.out.println(coll);
        coll.removeAll(coll1);
        System.out.println(coll);
        System.out.println("=======交集========");
        Collection coll2 = Arrays.asList(123,456,789);
        coll.retainAll(coll2);
        System.out.println(coll);

        Collection coll3 = new  ArrayList();
        coll3.add(123);
        coll3.add(456);
        coll3.add(789);
        System.out.println(coll2.equals(coll3));

        System.out.println(coll.hashCode());
        coll.clear();
        System.out.println(coll.size());


        Object[] arr = coll2.toArray();
        for (int i =0;i <arr.length;i++){
            System.out.println(arr[i]);
        }


        System.out.println("===数组 --->集合:调用Arrays类的静态方法asList()===");
        List<String> list = Arrays.asList(new String[]{"AA","bb","CC"});
        System.out.println(list);

        List arr1 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr1.size());//1

        List arr2 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr2.size());//2


    }
}
