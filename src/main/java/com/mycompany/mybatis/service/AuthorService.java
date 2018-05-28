/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mybatis.service;

import com.mycompany.mybatis.domain.Author;
import com.mycompany.mybatis.mapper.AuthorMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthorService {

    @Autowired
    AuthorMapper authorMapper;
    public List<Author> getAllAuthors() {
 
        return authorMapper.findAllAuthors();
    }
    
    public void addAuthor(Author author){
        
        authorMapper.addAuthor(author);
    }
    
}
