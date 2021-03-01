package com.ralph.Exer3;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class TestGetAnno {
    public static void main(String[] args) {
        Class studentClass = Student.class;
        Method[] declaredMethod = studentClass.getDeclaredMethods();
        for(Method m : declaredMethod){
            Annotation[] annotations = m.getAnnotations();
            for (Annotation a : annotations){
                System.out.println(a);
            }
        }

    }
}
