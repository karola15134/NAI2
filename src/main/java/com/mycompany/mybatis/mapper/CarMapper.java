/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mybatis.mapper;

import com.mycompany.mybatis.domain.Author;
import com.mycompany.mybatis.domain.Book;
import com.mycompany.mybatis.domain.Car;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CarMapper {
    
    @Select("SELECT * FROM cars")
    public List<Car> findAllCars();
    
    @Insert("INSERT INTO cars(brand,productionDate,numberOfDoors) values (#{brand},#{productionDate},#{numberOfDoors})")
    public Integer save(Car car);
    
    @Delete("DELETE FROM cars WHERE id =#{id}")
    public void removeCar(Long id);
    
    @Update("UPDATE cars SET brand=#{brand} , productionDate=#{productionDate} , numberOfDoors=#{numberOfDoors} WHERE id =#{id}")
    public void updateCar(Car car);
}
