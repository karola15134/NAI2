/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mybatis.dto;

public class AuthorDto {


    private String fName;

    private String lName;

    public AuthorDto() {
    }

    public AuthorDto(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
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
    
    
}
