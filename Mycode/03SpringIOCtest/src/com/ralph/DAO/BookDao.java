package com.ralph.DAO;


import org.springframework.stereotype.Repository;


@Repository("booksql")
//@Scope("prototype")
public class BookDao {
    public void saveBook(){
        System.out.println("save a book");
    }
}
