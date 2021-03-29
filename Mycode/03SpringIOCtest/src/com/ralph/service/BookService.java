package com.ralph.service;

import com.ralph.DAO.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    public void save(){
        System.out.println("<bookService> saving book!");
        this.bookDao.saveBook();
    }
}
