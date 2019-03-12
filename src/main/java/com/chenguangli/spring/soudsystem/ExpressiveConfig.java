package com.chenguangli.spring.soudsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.ArrayList;

@Configuration
@PropertySource("classpath:/app.properties")
public class ExpressiveConfig {

    @Autowired
    private Environment environment;

    @Bean
    public BlankDisc disc() {
        return new BlankDisc(environment.getProperty("disc.title","default value"), environment.getProperty("disc.artist"), new ArrayList<>());
    }
}
