package com.elibrary.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by nikolay on 23.07.17.
 */
@Configuration
public class AppConfig {

    @Bean
    public InitDatabase getInitDatabase() {
        return new InitDatabase();
    }

}
