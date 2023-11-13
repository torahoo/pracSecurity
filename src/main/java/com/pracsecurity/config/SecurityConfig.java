package com.pracsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Override
    protected void configure (HttpSecurity secu) throws Exception {
        // 모든 사용자들 접근 가능
        secu.authorizeRequests().antMatchers("/").permitAll();
        // 스프링 시큐리티에 의해 로그인되면 접근 가능
        secu.authorizeRequests().antMatchers("/main").authenticated();
        // member권한 접근 가능
        secu.authorizeRequests().antMatchers("/member/**").authenticated();
        // manager, admin만 접근 가능
        secu.authorizeRequests().antMatchers("/manager/**").hasAnyRole("MANAGER", "ADMIN");
        // admin만 접근 가능
        secu.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
        // csrf토큰 disable
        secu.csrf().disable();
        // 로그인 페이지와 성공했을 경우 넘어가는 페이지 설정
        secu.formLogin().loginPage("/login").defaultSuccessUrl("/main", true);
        // 로그인 에러시 넘어가는 login?error 페이지와 성공했을 경우 넘어가는 페이지 설정
        secu.formLogin().loginPage("/login?error").defaultSuccessUrl("/main", true);
        // 로그인 액션 프로세스 반드시 POST 그리고 성공시 URL
        secu.formLogin().loginProcessingUrl("/loginAction").defaultSuccessUrl("/main", true);
        // 실패시 URL
        secu.exceptionHandling().accessDeniedPage("/accessDenied");
        // 로그아웃 URL과 로그아웃 시 어디 URL로 갈 것인지
        secu.logout().logoutUrl("/logout").logoutSuccessUrl("/");
        //
        secu.userDetailsService(userDetailService);
    }

    @Bean
    public PasswordEncoder passwordEncoder () {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
