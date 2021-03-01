package com.ralph.java3;

import a.c.e.P;
import com.ralph.java2.Person;
import org.junit.Test;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Description: get run-time instance
 * Class:
 * Author:     ralph
 **/
public class FileTest {
    @Test
    public void Test1(){
        Class<Person> personClass = Person.class;


        //获取属性结构
        //getFields():获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = personClass.getFields();
        for (Field f:fields){
            System.out.println(f);
        }


        //getDeclaredFields():获取当前运行时类中声明的所有属性。（不包含父类中声明的属性）
        Field[] declaredFields = personClass.getDeclaredFields();
        for(Field f : declaredFields){
            System.out.println(f);
        }
    }

    @Test
    public void Test2(){
        Class<Person> clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field f : declaredFields){
            //1.权限修饰符
            int modifiers = f.getModifiers();
            System.out.println(modifiers); // 2 0 1
            System.out.println(Modifier.toString(modifiers));//显示出数字

            //2.数据类型
            Class type = f.getType();
            System.out.println(type.getName() + "\t");

            //3.变量名
            String fname = f.getName();
            System.out.println(fname);

        }
    }

    @Test
    public void Test3(){
        Class<Person> personClass1 = Person.class;

        //getMethods():获取当前运行时类及其所有父类中声明为public权限的方法
        Method[] methods = personClass1.getMethods();
        for (Method m : methods){
            System.out.println(m);
        }

        System.out.println();
        //getDeclaredMethods():获取当前运行时类中声明的所有方法。（不包含父类中声明的方法）
        Method[] declaredMethods = personClass1.getDeclaredMethods();
        for(Method m : declaredMethods){
            System.out.println(m);
        }

        System.out.println();
        //1.获取方法声明的注解
        Method[] declaredMethods1 = personClass1.getDeclaredMethods();
        for(Method m : declaredMethods1){
            Annotation[] annos = m.getAnnotations();
            for(Annotation a : annos){
                System.out.println(a);
            }


            //2.权限修饰符
            System.out.print(Modifier.toString(m.getModifiers()) + "\t");

            //3.返回值类型
            System.out.print(m.getReturnType().getName() + "\t");

            //4.方法名
            System.out.print(m.getName());
            System.out.print("(");

            //5.形参列表
            Class[] parameterTypes = m.getParameterTypes();
            if(!(parameterTypes == null && parameterTypes.length == 0)){
                for(int i = 0;i < parameterTypes.length;i++){

                    if(i == parameterTypes.length - 1){
                        System.out.print(parameterTypes[i].getName() + " args_" + i);
                        break;
                    }

                    System.out.print(parameterTypes[i].getName() + " args_" + i + ",");
                }
            }

            System.out.print(")");
            //6.抛出的异常
            Class[] exceptionTypes = m.getExceptionTypes();
            if(exceptionTypes.length > 0){
                System.out.print("throws ");
                for(int i = 0;i < exceptionTypes.length;i++){
                    if(i == exceptionTypes.length - 1){
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }

                    System.out.print(exceptionTypes[i].getName() + ",");
                }
            }


            System.out.println();

        }


    }
}
