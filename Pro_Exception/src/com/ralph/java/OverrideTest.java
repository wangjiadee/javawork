package com.ralph.java;

import java.io.FileNotFoundException;
import java.io.IOException;

/*
* 方法重写的规则之一：
* 子类重写的方法抛出的异常类型不大于父类被重写的方法抛出的异常类型
*
* 父类如果没有抛出异常那么子类就不能抛出异常
*
*
* 开发处理方式：
*   子类有异常 父类没有异常 使用try_catch_finally
*   a方法中并有递进关系的多个方法 先将这几个方法使用throw 然后在a方法外层使用try_catach_finnay
* */

public class OverrideTest {
    public static void main(String[] args) {
        OverrideTest test = new OverrideTest();
        test.display(new SubClass());
    }

    public void display(SuperClass s){
        try {
            s.method();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}


class SuperClass{
    public void method() throws IOException {
        }
}

class SubClass extends SuperClass{
    @Override
    public void method() throws FileNotFoundException {
//        super.method();
    }
}