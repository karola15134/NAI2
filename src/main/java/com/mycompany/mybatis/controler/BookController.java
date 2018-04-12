/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mybatis.controler;

import com.mycompany.mybatis.domain.Book;
import com.mycompany.mybatis.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {
    
     @Autowired
    private BookService bookService;
    
    @RequestMapping(value="allBooks",method = RequestMethod.GET)
    public String getAllBooks(Model model){
        
        
        List<Book> listOfBooks = bookService.getAllBooks();
        model.addAttribute("listOfBooks", listOfBooks);
        
        return "allBooks";
    }
}
