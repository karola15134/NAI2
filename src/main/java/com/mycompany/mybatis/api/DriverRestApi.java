/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mybatis.api;

import com.mycompany.mybatis.domain.Car;
import com.mycompany.mybatis.domain.Driver;
import com.mycompany.mybatis.dto.DriverDto;
import com.mycompany.mybatis.service.DriverService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/driver")
public class DriverRestApi {


    @Autowired
    private DriverService driverService;

    @RequestMapping(value = "/all")
    public List<Driver> getDrivers() {

        List<Driver> listOfDrivers = driverService.getAll();
        return listOfDrivers;

    }
    
    
    
     @RequestMapping(value="delete/{id}" , method=RequestMethod.DELETE)
     @ResponseBody
     public void remove(@PathVariable Long id)
     {
         
         driverService.removeDriver(id);
     }
     
     @RequestMapping(value="add")
     @ResponseBody
     public void add(@RequestBody Driver driver)
     {
         driverService.addDriver(driver);
     }
     
     @RequestMapping(value="update" , method=RequestMethod.PUT)
     @ResponseBody
     public void update(@RequestBody Driver driver) 
     {
         driverService.update(driver);
     }


}
