/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mybatis.mapper;



import com.mycompany.mybatis.domain.Book;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface BookMapper {
    
    @Select("SELECT * FROM BOOKS WHERE title = #{title}")
    Book findByName(@Param("title") String title);
    
    @Select("SELECT * FROM BOOKS ")
    List<Book> findAllBooks();
}
