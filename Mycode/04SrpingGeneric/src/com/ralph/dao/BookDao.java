package com.ralph.dao;

import com.ralph.bean.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao extends BaseDao<Book> {

    @Override
    public void save() {
        System.out.println("save book for bookdao");
    }
}
