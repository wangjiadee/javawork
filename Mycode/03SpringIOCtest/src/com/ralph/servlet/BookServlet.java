package com.ralph.servlet;

import com.ralph.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookServlet {
    @Autowired
    private BookService bookService;

    public void doGet(){
        this.bookService.save();
    }
}
