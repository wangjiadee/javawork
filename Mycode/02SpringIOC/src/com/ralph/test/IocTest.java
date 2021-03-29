package com.ralph.test;

import com.ralph.bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class IocTest {

    private ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    private ConfigurableApplicationContext context2 = new ClassPathXmlApplicationContext("applicationContext2.xml");
    private ConfigurableApplicationContext sqlcontext  = new ClassPathXmlApplicationContext("sql.xml");


    @Test
    public void lifeTimeDemo(){
        Object book1 = context.getBean("book1");
        System.out.println("close!");
    }

    @Test
    public void sqlTestDemo() throws SQLException {
        DataSource dataSource = (DataSource) sqlcontext.getBean("dataSource");
        System.out.println(dataSource.getConnection());

    }

    @Test
    public void manualTest(){
        Object car1 = context2.getBean("car1");
        System.out.println(car1);
        Person person = (Person) context2.getBean("person");
        System.out.println(person);

    }
}
