/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mybatis.domain;


public class Driver {
    
     private Long id;
     
     private String fName;
     
     private String lName;
     
     private String drivingLicDate;
     
     private String categories;
     
  

    public Driver() {
        
    }



    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getDrivingLicDate() {
        return drivingLicDate;
    }

    public void setDrivingLicDate(String drivingLicDate) {
        this.drivingLicDate = drivingLicDate;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }
     
     
    
}
