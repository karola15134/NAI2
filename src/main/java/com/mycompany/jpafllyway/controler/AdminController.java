/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jpafllyway.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {
    
    
    
    @RequestMapping("/home")
    public String home(){
        
        return "adminHome";
            
    }
    
    @RequestMapping(value= "/language" , method = RequestMethod.GET)
    public String language(){
        
        return "adminLang";
    }
    
}
