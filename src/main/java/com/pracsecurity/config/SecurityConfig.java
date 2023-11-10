package com.pracsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfig extends WebSecurityConfiguration implements WebMvcConfigurer {

    @Override
    protected void configure (HttpSecurity secu) throws Exception {
        secu.authorizeRequests().antMatchers("/").permitAll(); // 모든 사용자들 접근 가능
        secu.authorizeRequests().antMatchers("/main").authenticated(); // 스프링 시큐리티에 의해 로그인되면 접근 가능
    }

}
