package com.yk.att.mtbs.movies.configuration;


import com.yk.att.mtbs.security.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil();
    }
}
