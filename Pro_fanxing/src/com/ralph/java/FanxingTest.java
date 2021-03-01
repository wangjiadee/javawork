package com.ralph.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class FanxingTest {

    @Test
    public void Test1(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(4);

        for (Integer i : list){
            System.out.println(i);
        }

        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }



    /**
     * Description:开发一个泛型Apple类，要求有一个重量属性weight在测试类中实例化不同的泛型对象，要求对象a1的这一属性是String类型，
     * 对象a2的这一属性是Integer型，a3的这一属性是Double型。
     * 分别为a1，a2，a3的重量属性赋值为：”900克”，900,900.0，在测试类中通过对象调用访问器得到属性值并输出。
     * 另外思考，为什么a2和a3的属性需要是Integer和Double而不是int和double？

     * return
     * Author:     ralph
     **/
    @Test
    public void Test2(){
        Apple<String> a1 = new Apple<>("900克");
        Apple<Integer> a2 = new Apple<>(900);
        Apple<Double> a3 = new Apple<>(900.0);
        System.out.println(a1.getWeight());
        System.out.println(a2.getWeight());
        System.out.println(a3.getWeight());
    }


    @Test
    public void Test3(){
        Demo<String> demo = new Person();
        String str = demo.eat("吃饭");
        System.out.println(str);
    }

}


interface Demo<T>{
    public T eat(T t);
}

class Person implements Demo<String>{
    @Override
    public String eat(String s){
        return s;
    }
}

class Apple<RAL>{
    private RAL weight;

    public RAL getWeight() {
        return weight;
    }

    public void setWeight(RAL weight) {
        this.weight = weight;
    }

    public Apple(RAL weight) {
        this.weight = weight;
    }

    public Apple() {
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                '}';
    }
}


class FU<T1>{
    private T1 info;

    public T1 getInfo() {
        return info;
    }

    public void setInfo(T1 info) {
        this.info = info;
    }

    public FU(T1 info) {
        this.info = info;
    }

    // static的方法中不能声明泛型
//    public static void show(T1 t) {
//
//    }

    //不能在try-catch中使用泛型定义


}

