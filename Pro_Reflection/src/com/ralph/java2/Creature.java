package com.ralph.java2;

import java.io.Serializable;

//自定义泛型 + 实现接口
public class Creature<T> implements Serializable {
    private  char gender;
    public double weight;
    private void breath(){
        System.out.println("Creature breath");
    }

    public void eat(){
        System.out.println("Creature eat");
    }
}
