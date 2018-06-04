/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mybatis.controller;

import com.mycompany.mybatis.domain.Author;
import com.mycompany.mybatis.domain.Book;
import com.mycompany.mybatis.dto.AuthorDto;
import com.mycompany.mybatis.service.AuthorService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(path = "private")
@Controller
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(value = "allAuthors", method = RequestMethod.GET)
    public String getAllAuthors(Model model) {

        List<Author> listOfAuthors = authorService.getAllAuthors();
        List<AuthorDto> listOfAuthorsDto = listOfAuthors.stream().map(author -> convertToDto(author))
.collect(Collectors.toList());
        model.addAttribute("listOfAuthors", listOfAuthorsDto);

        return "allAuthors";
    }

    
    
    @RequestMapping(value="addAuthor",method = RequestMethod.GET)
    public String addAuthorGet(Model model){
        
        AuthorDto authorDto = convertToDto(new Author());
        model.addAttribute("author", authorDto);
        return "addAuthor";
    }
    
    
    
    @RequestMapping(value="addAuthor",method = RequestMethod.POST)
    public String addAuthor(@ModelAttribute("author")Author author){
        
        authorService.addAuthor(author);
        return "successAddAuthor";
        
    }
    
    @RequestMapping(value="getAuthors",method = RequestMethod.GET)
    @ResponseBody
    public List<Author> getAuthors(){
        
        return authorService.getAllAuthors();
    }
    
    
    
    private AuthorDto convertToDto(Author author) {

        AuthorDto authorDto = modelMapper.map(author, AuthorDto.class);

        return authorDto;

    }

    private Author convertToEntity(AuthorDto authorDto) {

        Author author = modelMapper.map(authorDto, Author.class);

        return author;
    }

}
