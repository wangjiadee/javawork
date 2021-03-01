package com.ralph.java;

import org.junit.Test;
import sun.misc.Unsafe;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Random;

public class ReflectionTest {

    @Test
    public void Test1(){
        //创建Person类的对象
        Person p1 = new Person("OpV",12);
        //调用内部的属性、方法
        p1.age = 100;
        System.out.println(p1.toString());
        p1.show();

    }

    @Test
    public void Test2() throws Exception {
        //通过反射，创建Person类的对象
        Class clzz = Person.class;
        Constructor cons = clzz.getConstructor(String.class, int.class);
        Object tom = cons.newInstance("TOM", 22);
        Person p = (Person) tom;
        System.out.println(p.toString());
        //通过反射，调用对象指定的属性、方法
        //调用属性
        Field age = clzz.getDeclaredField("age");
        age.set(p,1999);
        System.out.println(p.toString());

        //调用方法
        Method show = clzz.getDeclaredMethod("show");
        show.invoke(p);

        System.out.println("====调用私有的构造器====");

        Constructor declaredConstructor = clzz.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        Person p1 = (Person) declaredConstructor.newInstance("Jerry");
        System.out.println(p1);

        System.out.println("=====调用私有的属性====");
        Field name = clzz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"NiMAMA");
        System.out.println(p1);

        System.out.println("=====调用私有的方法=====");
        Method showNation = clzz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1,"USA");
        System.out.println(nation);


    }


    @Test
    public void Test3() throws ClassNotFoundException {
        //方式一：调用运行时类的属性：.class
        Class clazz = Person.class;
        System.out.println(clazz);
        //方式二：通过运行时类的对象,调用getClass()
        Person person = new Person();
        Class clazz2 = person.getClass();
        System.out.println(clazz2);

        //方式三：调用Class的静态方法：forName(String classPath)
        Class clazz3 = Class.forName("com.ralph.java.Person");
        System.out.println(clazz3);

        System.out.println(clazz == clazz2);
        System.out.println(clazz == clazz3);


        //方式四：使用类的加载器：ClassLoader  (了解)
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("com.ralph.java.Person");
        System.out.println(clazz4);

        System.out.println(clazz == clazz4);
    }


    @Test
    public void Test4() throws Exception {
        Properties pros =  new Properties();

        //此时的文件默认在当前的module下。
        //读取配置文件的方式一：
//        FileInputStream fileInputStream = new FileInputStream("jdb.properties");
        //在src中
//        FileInputStream fileInputStream = new FileInputStream("src\\jdb.properties");
//        pros.load(fileInputStream);

        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdb.properties");
        pros.load(is);

        String user = pros.getProperty("Username");
        String password = pros.getProperty("Password");
        System.out.println("user = " + user + ",password = " + password);

    }

    @Test
    public void NewInstanceT() throws IllegalAccessException, InstantiationException {
        Class<Person> clazz = Person.class;
        Person person = clazz.newInstance();
        System.out.println(person);
    }


    @Test
    public void test5() {

        for (int i = 0; i < 100; i++) {
            int num = new Random().nextInt(3);//0,1,2
            String classPath = "";
            switch (num) {
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "com.ralph.java.Person";
                    break;
            }

            try {
                Object obj = getInstance(classPath);
                System.out.println(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public Object getInstance(String classPath) throws Exception{
        Class aClass = Class.forName(classPath);
        return aClass.newInstance();
    }

}


