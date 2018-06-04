/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mybatis.service;

import com.mycompany.mybatis.domain.Driver;
import com.mycompany.mybatis.email.EmailSenderImpl;
import com.mycompany.mybatis.mapper.DriverMapper;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class DriverService {

    @Autowired
    private DriverMapper driverMapper;

    @Autowired
    private EmailSenderImpl sender;

    String name = DriverService.class.getName();

    private final Logger logger = Logger.getLogger(name);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public List<Driver> getAll() {

        return driverMapper.findAllDrivers();

    }

    public void addDriver(Driver driver) {
        driverMapper.save(driver);
    }

    public void removeDriver(Long id) {
        driverMapper.removeDriver(id);
    }

    public void update(Driver driver) {
        driverMapper.updateDriver(driver);
    }

    @Scheduled(fixedRate = 5000)
    public void count() {
        String count = String.valueOf(driverMapper.count());
        logger.info("DRIVERS COUNT: " + count + " AT " + dateFormat.format(new Date()));

    }

    @Scheduled(cron="0 0 8,20 * * *")
    public void countToMail() {
        StringBuilder builder = new StringBuilder();
        builder.append("Number of drivers in Spring Boot Application:  ");
        builder.append(String.valueOf(driverMapper.count()));
        builder.append("           Date: ");
        builder.append(new Date());
        
        logger.info("EMAIL");
        
        String content = builder.toString();
        sender.sendEmail("karolina.sz1993@gmail.com", " Spring Boot App - Drivers Count", content);
        
    }

}
