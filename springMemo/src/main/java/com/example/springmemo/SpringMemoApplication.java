package com.example.springmemo;

import com.example.springmemo.practice.AppContext;
import com.example.springmemo.practice.dev;
import com.example.springmemo.practice.prod;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringMemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMemoApplication.class, args);

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("prod");
        ctx.register(AppContext.class, dev.class, prod.class);
        ctx.refresh();

        AppContext context = ctx.getBean(AppContext.class);
        System.out.println("env : " + context.helloEnv);
    }

}
