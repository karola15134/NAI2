/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mybatis.conf;

import com.mycompany.mybatis.interceptor.RedirectInterceptor;
import com.mycompany.mybatis.interceptor.TimeInterceptor;
import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    
 
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/private").setViewName("private");
        registry.addViewController("/public").setViewName("public");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/public/cars").setViewName("allCars");
        registry.addViewController("/public/drivers").setViewName("allDrivers");
        
    }
    
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
       // sessionLocaleResolver.setDefaultLocale(Locale.forLanguageTag("pl"));
        return sessionLocaleResolver;
    }
    
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor((HandlerInterceptor) new TimeInterceptor())
                .addPathPatterns("/private/**");
        registry.addInterceptor(new RedirectInterceptor())
                .addPathPatterns("/admin");
        registry.addInterceptor(localeChangeInterceptor());
        
}
        
    }