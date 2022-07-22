package com.example.springmemo.practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class prod {
    @Bean
    public String helloEnv() {
        return "Prod";
    }
}
