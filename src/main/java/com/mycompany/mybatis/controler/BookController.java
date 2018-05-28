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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RequestMapping(path="private")
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
    
    @RequestMapping(value="addBook",method = RequestMethod.GET)
    public String addBookGet(Model model){
        
        model.addAttribute("book", new Book());
        return "addBook";
    }
    
    
    
    @RequestMapping(value="addBook",method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book")Book book){
        
        bookService.addBook(book);
        return "succesAdd";
        
    }
    
    
    
    @RequestMapping(value="deleteBook" , method = RequestMethod.GET)
    public String deleteBook(Model model){
        
        List<Book> listOfBooks = bookService.getAllBooks();
        model.addAttribute("listOfBooks", listOfBooks);
        model.addAttribute("book",new Book());
        
        return "deleteBook";
    }
    
     @RequestMapping(value="deleteBook" , method = RequestMethod.POST)
     public String deleteBookPost(Model model,Book book)
     {     
         bookService.deleteBook(book);
         List<Book> listOfBooks = bookService.getAllBooks();
         model.addAttribute("listOfBooks", listOfBooks);
         
         return "deleteBook";
     }
     
     @RequestMapping(value="editBook" , method = RequestMethod.GET)
     public String editBookGet(Model model){
         
         List<Book> listOfBooks = bookService.getAllBooks();
        model.addAttribute("listOfBooks", listOfBooks);
        model.addAttribute("book",new Book());
         
        return "updateBook";
     }
     
      @RequestMapping(value="editBook" , method = RequestMethod.POST)
       public String editBookPost(Model model,Book book){
           
           bookService.updateBook(book);
           List<Book> listOfBooks = bookService.getAllBooks();
           model.addAttribute("listOfBooks", listOfBooks);
           return "updateBook";
       }
     


}
