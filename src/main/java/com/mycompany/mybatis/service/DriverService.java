/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mybatis.service;

import com.mycompany.mybatis.domain.Driver;
import com.mycompany.mybatis.mapper.DriverMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {
    
    @Autowired
    private DriverMapper driverMapper;
    
    public List<Driver> getAll(){
         
        return driverMapper.findAllDrivers();
        
    }

    public void addDriver (Driver driver) {
       driverMapper.save(driver);
    }

    public void removeDriver(Long id) {
      driverMapper.removeDriver(id);
    }

    public void update(Driver driver) {
        driverMapper.updateDriver(driver);
    }
    
    
}
