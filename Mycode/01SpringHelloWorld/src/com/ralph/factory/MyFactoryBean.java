package com.ralph.factory;

import com.ralph.bean.Book;
import org.springframework.beans.factory.FactoryBean;

import java.util.UUID;

//自定义工厂
public class MyFactoryBean implements FactoryBean<Book> {

    /**
     * Description:判断是否是单例模式

     * return
     * Author:     ralph
     **/
    @Override
    public boolean isSingleton() {
        return false;
    }

    /**
     * Description: 返回创建的对象

     * return
     * Author:     ralph
     **/
    @Override
    public Book getObject() throws Exception {
        System.out.println("FactoryBean auto create Object");
        Book book = new Book();
        book.setBookName(UUID.randomUUID().toString());
        return book;
    }

    /**
     * Description: 返回创建的对象类型
     * Spring 会自动的调用这个方法来确定创建的对象是什么类型

     * return
     * Author:     ralph
     **/
    @Override
    public Class<?> getObjectType() {
        return Book.class;
    }
}
