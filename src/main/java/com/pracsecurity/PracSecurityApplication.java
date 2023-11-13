package com.pracsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class PracSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracSecurityApplication.class, args);
    }

}
