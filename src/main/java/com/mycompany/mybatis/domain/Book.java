/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mybatis.domain;

import java.io.Serializable;


public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String title;

    private Integer numbOfPages;

    private Author author = new Author();

    public Book() {
        
    }

    public Book(Long id, String title, Integer numbOfPages, Author author) {
        this.id = id;
        this.title = title;
        this.numbOfPages = numbOfPages;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNumbOfPages() {
        return numbOfPages;
    }

    public void setNumbOfPages(Integer numbOfPages) {
        this.numbOfPages = numbOfPages;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return getId() + "," + getTitle() + "," + getNumbOfPages();
    }

}
