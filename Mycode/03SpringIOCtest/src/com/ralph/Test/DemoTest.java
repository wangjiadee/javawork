package com.ralph.Test;

import com.ralph.service.BookService;
import com.ralph.servlet.BookServlet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DemoTest {

//    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    ApplicationContext ioc = null;
    @Test
    public void test1(){
        Object bookDao = ioc.getBean("booksql");
        Object bookDao1 = ioc.getBean("booksql");

        System.out.println(bookDao == bookDao1);
    }


    @Test
    public void AutowiredTest(){
        BookServlet bean = ioc.getBean(BookServlet.class);

        bean.doGet();
    }


    @Autowired
    BookServlet bookServlet;

    @Test
    public void springTest(){
        System.out.println(bookServlet);
    }
}
