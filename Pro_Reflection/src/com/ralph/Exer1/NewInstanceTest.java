package com.ralph.Exer1;

import java.lang.reflect.Method;
/**
 * Description:
 * Class:
 * Author:     ralph
 **/
public class NewInstanceTest {
    public static void main(String[] args) throws Exception {
        Class<Student> studentClass = Student.class;

        Student student = (Student) studentClass.newInstance();

        //Call no-argument function
        Method show = studentClass.getDeclaredMethod("show");
        show.setAccessible(true);
        Object returnVal = show.invoke(student);
        System.out.println(returnVal);

        //Call argument function
        Method display = studentClass.getDeclaredMethod("display",String.class);
        display.setAccessible(true);
        Object returnVal1 = display.invoke(student,"CHN");
        System.out.println(returnVal1);


    }
}
