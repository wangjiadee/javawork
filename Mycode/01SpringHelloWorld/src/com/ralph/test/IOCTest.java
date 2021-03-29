package com.ralph.test;

import com.ralph.bean.Book;
import com.ralph.bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

public class IOCTest {

    private ApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
    private ApplicationContext context2 = new ClassPathXmlApplicationContext("ioc2.xml");
    private ApplicationContext context3 = new ClassPathXmlApplicationContext("FactoryBeanioc.xml");


    /**
     * Description: 从容器中获取这个组件（类）
     * return
     * Author:     ralph
     **/
    @Test
    public void demoTest1(){
        //ApplicationContext 表示当前容器
        Object person1 = context.getBean("person1");
        System.out.println(person1);


    }

    @Test
    public void demoTest2(){
        // org.springframework.beans.factory.NoUniqueBeanDefinitionException:
        // No qualifying bean of type 'com.ralph.bean.Person'
        // available: expected single matching bean but found 2: person1,person2
//        Person bean = context.getBean(Person.class);
//        System.out.println(bean);

        Person person2 = context.getBean("person2", Person.class);
        System.out.println(person2);
    }

    @Test
    public void useConstructorTest(){
        Person person3 = context.getBean("person3", Person.class);
        System.out.println(person3);
    }

    @Test
    public void useNamespaceTest(){
        Person person4 = context.getBean("person4", Person.class);
        System.out.println(person4);
    }

    @Test
    public void p1test(){
        Person person1 = (Person) context2.getBean("person1");
        System.out.println(person1);
        System.out.println(person1.getCar());
    }

    @Test
    public void p2test(){
        Person person1 = (Person) context2.getBean("person1");
        System.out.println(person1.getCar());

    }

    @Test
    public void p3test(){
        Person person2 = (Person) context2.getBean("person2");
        List<Book> books = person2.getBooks();
        System.out.println(books);
    }

    @Test
    public void p4Maptest(){
        Person person4 = (Person) context2.getBean("person2");
        Map<String, Object> maps = person4.getMaps();
        System.out.println(maps);
    }


    @Test
    public void contest1(){
        Person person4 = (Person) context2.getBean("person4");
        Object car1 = context2.getBean("car1");
        System.out.println(car1);
        System.out.println(person4.getCar());
    }

    @Test
    public void parantTest(){
        Person person6 = (Person) context2.getBean("person6");
        System.out.println(person6);
    }

    @Test
    public void simpleInstanTest(){
        System.out.println("容器创建成功");
        Object book1 = context2.getBean("book1");
        Object book2 = context2.getBean("book1");
        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book2 == book1);

    }

    @Test
    public void factoryStaticdemo(){
        System.out.println("容器创建成功");
        Object apstatic = context2.getBean("apstatic");
        System.out.println(apstatic);

    }
    @Test
    public void factoryInstancedemo(){
        System.out.println("容器创建成功");
        Object api2 = context2.getBean("api2");
        System.out.println(api2);

    }

    @Test
    public void factoryBeanDemo(){
        Object myFactoryBean = context3.getBean("myFactoryBean");
        System.out.println(myFactoryBean);
    }
}

