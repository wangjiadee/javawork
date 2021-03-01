package com.ralph.java2;

import a.c.e.P;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {

    @Test
    public void Test1() throws Exception {
        Class<Person> personClass = Person.class;

        Person p = (Person) personClass.newInstance();

        Field fieldID = personClass.getField("id");
        fieldID.set(p,1111);
        int pid = (int) fieldID.get(p);
        System.out.println(pid);
    }

    /**
     * Description:如何操作运行时类中的指定的属性

     * return
     * Author:     ralph
     **/
    @Test
    public void RunGetAttributes() throws Exception{
        Class<Person> personClass = Person.class;

        //创建运行时类的对象
        Person person = (Person) personClass.newInstance();

        //1. getDeclaredField(String fieldName):获取运行时类中指定变量名的属性
        Field name = personClass.getDeclaredField("name");

        //2.保证当前属性是可访问的
        name.setAccessible(true);

        //3.获取、设置指定对象的此属性值
        name.set(person,"MDZA");

        System.out.println(name.get(person));

    }


    @Test
    public void RunGetMethod() throws Exception{
        Class<Person> personClass = Person.class;
        //创建运行时类的对象
        Person person = (Person) personClass.newInstance();
        /*
        1.获取指定的某个方法
        getDeclaredMethod():参数1 ：指明获取的方法的名称  参数2：指明获取的方法的形参列表
         */
        Method show = personClass.getDeclaredMethod("show", String.class);
        //2.保证当前方法是可访问的
        show.setAccessible(true);
        /*
        3. 调用方法的invoke():参数1：方法的调用者  参数2：给方法形参赋值的实参
        invoke()的返回值即为对应类中调用的方法的返回值。
         */
        Object usa = show.invoke(person, "USA");
        System.out.println(usa);

        System.out.println("*************如何调用静态方法*****************");
        Method showDesc = personClass.getDeclaredMethod("showDesc");
        //如果调用的运行时类中的方法没有返回值，则此invoke()返回null
//        Object returnVal = showDesc.invoke(null);
        Object returnval = showDesc.invoke(Person.class);
        System.out.println(returnval);

    }

    @Test
    public void testConstructor() throws Exception {
        Class clazz = Person.class;

        //private Person(String name)
        /*
        1.获取指定的构造器
        getDeclaredConstructor():参数：指明构造器的参数列表
         */

        Constructor constructor = clazz.getDeclaredConstructor(String.class);

        //2.保证此构造器是可访问的
        constructor.setAccessible(true);

        //3.调用此构造器创建运行时类的对象
        Person per = (Person) constructor.newInstance("Tom");
        System.out.println(per);

    }

}
