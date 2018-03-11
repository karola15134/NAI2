/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jpafllyway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.flywaydb.core.Flyway;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
                
                 Flyway flyway = new Flyway();
                 flyway.setDataSource("jdbc:mysql://localhost:3306/db_person","springuser","ThePassword");
           
                 flyway.migrate();
	}
}