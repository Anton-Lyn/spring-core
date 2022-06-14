package com.epam.training;

import com.epam.training.service.impl.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Api {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Api.class);
    }
}
