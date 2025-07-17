package com.javanauta.bffagendadortarefas.infraestructure.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public FeignError feingError(){
        return new FeignError();
    }
}
