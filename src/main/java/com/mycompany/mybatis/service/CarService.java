/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mybatis.service;

import com.mycompany.mybatis.domain.Car;
import com.mycompany.mybatis.mapper.CarMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    
    @Autowired
    private CarMapper carMapper;
    
    public List<Car> getAllCars(){
         
        return carMapper.findAllCars();
        
    }

    public void addCar(Car car) {
       carMapper.save(car);
    }

    public void removeCar(Long id) {
      carMapper.removeCar(id);
    }

    public void update( Car car) {
        carMapper.updateCar(car);
    }
    
    
    
}
