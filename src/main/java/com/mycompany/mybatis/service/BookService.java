/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mybatis.service;

import com.mycompany.mybatis.domain.Book;
import com.mycompany.mybatis.mapper.BookMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    
     @Autowired
    private BookMapper bookMapper;
     
     public List<Book> getAllBooks(){
        
        List<Book> listOfBooks;
        listOfBooks = (List<Book>) bookMapper.findAllBooks();
        return listOfBooks;
    }

    public void addBook(Book book) {
      bookMapper.addBook(book);
    }

    public void deleteBook(Book book) {
        bookMapper.deleteBook(book.getId());
    }

    public void updateBook(Book book) {
        
        bookMapper.updateBook(book);
        
    }

    
}
