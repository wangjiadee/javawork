package com.ralph.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class MyCollectionTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(343);
        coll.add(343);

        coll.forEach(System.out::println);
    }


    public static List duplicateList(List list){
        HashSet h = new HashSet();
        h.addAll(list);
        return  new ArrayList(h);
    }

    @Test
    public void Test2(){
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(new Integer(1));
        arrayList.add(new Integer(1));
        arrayList.add(new Integer(2));
        arrayList.add(new Integer(2));
        arrayList.add(new Integer(4));
        arrayList.add(new Integer(4));

        List list2 = duplicateList(arrayList);
        for (Object i :list2){
            System.out.println(i);
        }
    }


    @Test
    public void Test3(){
        HashSet<Object> objects = new HashSet<>();
        Person p1 = new Person(80281, "Tom");
        Person p2 = new Person(30281, "MMA");
        Person p3 = new Person(40581,"JoY");


        objects.add(p1);
        objects.add(p2);
        objects.add(p3);
        System.out.println(objects);
        //[Person{id=30281, name='MMA'}, Person{id=40581, name='JoY'}, Person{id=80281, name='Tom'}]

        p1.name = "DDD"; //修改集合中某个属性 = 添加了新的
        objects.remove(p1); //原来的删除  后面的还保留
        System.out.println(objects);
        //[Person{id=30281, name='MMA'}, Person{id=40581, name='JoY'}, Person{id=80281, name='DDD'}]

        objects.add(new Person(80281,"DDD")); //多一个新的
        System.out.println(objects);
        //[Person{id=10001, name='DDD'}, Person{id=30281, name='MMA'}, Person{id=40581, name='JoY'}, Person{id=80281, name='DDD'}]

        objects.add(new Person(80281,"Tom"));
        System.out.println(objects);
        //[Person{id=10001, name='DDD'}, Person{id=30281, name='MMA'}, Person{id=40581, name='JoY'}, Person{id=80281, name='DDD'}, Person{id=80281, name='Tom'}]

    }
}
