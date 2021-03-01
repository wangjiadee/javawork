package com.ralph.Exer2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class NewInstanceTest1 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<Mytxt> mytxtClass = Mytxt.class;
        Mytxt mytxt = (Mytxt) mytxtClass.newInstance();

        Method myCreate = mytxtClass.getDeclaredMethod("myCreate");
        myCreate.setAccessible(true);
        Object returnVal = myCreate.invoke(mytxt,null);
        System.out.println(returnVal);
    }
}
