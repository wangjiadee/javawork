package com.ralph.Test;


import com.ralph.service.BookService;
import com.ralph.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoT {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test1(){
        BookService bean = ioc.getBean(BookService.class);
        UserService bean1 = ioc.getBean(UserService.class);
        bean.save();
        bean1.save();
    }

}
