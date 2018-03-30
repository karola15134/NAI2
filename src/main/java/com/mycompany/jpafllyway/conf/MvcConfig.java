/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jpafllyway.conf;

import com.mycompany.jpafllyway.interceptor.RedirectInterceptor;
import com.mycompany.jpafllyway.interceptor.TimeInterceptor;
import java.util.Locale;
import java.util.logging.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    
    private static final Logger log = Logger.getLogger(MvcConfig.class.getName());

    @Override
    
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
        
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
        registry.addInterceptor(new TimeInterceptor())
                .addPathPatterns("/admin/**");
        registry.addInterceptor(new RedirectInterceptor())
                .addPathPatterns("/admin/homeAdmin");
        registry.addInterceptor(localeChangeInterceptor());
        
    }
    
}
