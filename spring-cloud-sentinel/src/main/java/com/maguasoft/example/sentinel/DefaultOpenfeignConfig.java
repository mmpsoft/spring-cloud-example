package com.maguasoft.example.sentinel;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"local", "dev", "test"})
public class DefaultOpenfeignConfig {

    @Bean
    public Logger.Level openfeignLoggerLevel() {
        return Logger.Level.HEADERS;
    }
}
