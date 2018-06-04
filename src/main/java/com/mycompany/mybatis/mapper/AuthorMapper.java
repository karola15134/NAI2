/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mybatis.mapper;

import com.mycompany.mybatis.domain.Author;
import com.mycompany.mybatis.domain.Book;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface AuthorMapper {

    @Select("SELECT * FROM authors where lName = #{lName}")
    @Results(value = {
        @Result(property = "books", javaType = List.class, column = "books",
                many = @Many(select = "findBookByAuthor"))})
    public Author findAuthorByLname();

    @Select("SELECT * FROM books where books.author = #{authors.id}")
    public List<Book> findBookByAuthor(String lName);

    @Select("SELECT * FROM authors")
    public List<Author> findAllAuthors();


    @Insert("INSERT INTO authors(fName,lName) values (#{fName},#{lName})")
    public Integer save(Author author);

    @Update("UPDATE authors set fName= #{fName} , lName=#{lName} where id=#{id}")
    public void updateAuthor(long id);

    @Delete("DELETE FROM authors where where id=#{id}")
    public void deleteAuthorById(long id);
    
  

}
