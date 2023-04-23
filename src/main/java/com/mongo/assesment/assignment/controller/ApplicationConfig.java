package com.mongo.assesment.assignment.controller;

import com.mongo.assesment.assignment.service.ApplicationService;
import com.mongo.assesment.assignment.service.UsersUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public UsersUseCase usersUseCase(final ApplicationService service){
        return new UsersUseCase(service);
    }
}
