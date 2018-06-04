/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mybatis.mapper;

import com.mycompany.mybatis.domain.Driver;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DriverMapper {

    
    @Select("SELECT * from drivers")
    public List<Driver> findAllDrivers();

    @Insert("INSERT INTO drivers(fName,lName,drivingLicDate,categories) VALUES (#{fName}, #{lName} , #{drivingLicDate} , #{categories)")
    public void save(Driver driver);

    @Delete("DELETE FROM drivers WHERE id =#{id}")
    public void removeDriver(Long id);

    @Update("UPDATE drivers SET fName=#{fName} , lName=#{lName} , drivingLicDate=#{drivingLicDate} , categories=#{categories} WHERE id =#{id}")
    public void updateDriver(Driver driver);
    
}
