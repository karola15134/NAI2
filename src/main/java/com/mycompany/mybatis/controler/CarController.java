/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mybatis.controler;

import com.mycompany.mybatis.domain.Book;
import com.mycompany.mybatis.domain.Car;
import com.mycompany.mybatis.service.CarService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(path="public")
@Controller
public class CarController {
     
    @Autowired
    CarService carService;
    
     @RequestMapping(value="cars",method = RequestMethod.GET)
     public String getAllCars(Model model){
         
        List<Car> listOfCars = carService.getAllCars();
        model.addAttribute("listOfCars",listOfCars);
         return "allCars";
     }
     
     @RequestMapping(value="all" , method=RequestMethod.GET ,  produces="application/json")
     @ResponseBody
     public List<Car> getAllCarsRest(){
         
         return carService.getAllCars();
     }
     
     
     
     @RequestMapping(value="delete/{id}" , method=RequestMethod.DELETE)
     @ResponseBody
     public void removeCar(@PathVariable Long id)
     {
         carService.removeCar(id);
     }
     
     @RequestMapping(value="add")
     @ResponseBody
     public void addCar(@RequestBody Car car)
     {
         carService.addCar(car);
     }
     
     @RequestMapping(value="update" , method=RequestMethod.PUT)
     @ResponseBody
     public void updateCar(@RequestBody Car car) 
     {
         carService.update(car);
     }
     
}
