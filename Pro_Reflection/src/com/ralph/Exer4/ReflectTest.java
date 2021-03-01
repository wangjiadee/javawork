package com.ralph.Exer4;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTest {
    public static void main(String[] args) throws Exception {
        Class privateTestClass = PrivateTest.class;
        PrivateTest pt = (PrivateTest) privateTestClass.newInstance();

        Field[] declaredFields = privateTestClass.getDeclaredFields();
        for (Field f : declaredFields){
            System.out.println(f);

            String fName = f.getName();
            System.out.print(fName);
        }

        System.out.println();
        Method getName = privateTestClass.getDeclaredMethod("getName");
        getName.setAccessible(true);

        Object value = getName.invoke(pt);
        System.out.println(value);

    }
}
