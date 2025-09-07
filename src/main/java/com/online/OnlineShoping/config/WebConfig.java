package com.online.OnlineShoping.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.online.OnlineShoping.constans.Constants;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(Constants.FRONTEND_URL_CROSS_ORIGIN)
                        .allowedMethods(Constants.GET_REQUEST,Constants.POST_REQUEST,Constants.PUT_REQUEST,
                        		Constants.DELETE_REQUEST,Constants.OPTIONS_REQUEST)
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}