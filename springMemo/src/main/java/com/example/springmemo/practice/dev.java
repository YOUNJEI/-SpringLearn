package com.example.springmemo.practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class dev {
    @Bean
    public String helloEnv() {
        return "Dev";
    }
}