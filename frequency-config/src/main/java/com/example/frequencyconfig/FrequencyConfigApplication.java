package com.example.frequencyconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class FrequencyConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrequencyConfigApplication.class, args);
    }
}
