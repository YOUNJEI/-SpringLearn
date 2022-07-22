package com.example.springmemo.practice;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppContext {
    @Autowired(required = false)
    public String helloEnv;
}
