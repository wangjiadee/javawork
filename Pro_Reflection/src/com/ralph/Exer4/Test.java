package com.ralph.Exer4;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    @org.junit.Test
    public void Test1() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //利用Class类的forName方法得到File类
        Class aClass = Class.forName("java.io.File");

        //在控制台打印File类的所有构造器
        Constructor[] declaredConstructor = aClass.getDeclaredConstructors();
        for(Constructor con : declaredConstructor) System.out.println(con);

        //获取File的一个构造器
        Constructor constructor = aClass.getConstructor(String.class);
        //用上面得到构造器创建File对象
        Object instance = constructor.newInstance("./mynew.txt");

        //获取File的createNewFile方法
        Method createNewFile = aClass.getMethod("createNewFile");
        createNewFile.invoke(instance);


    }
}
