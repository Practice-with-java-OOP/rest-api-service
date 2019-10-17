package com.syphan.practice.boardinghouserestfullapi.security;

import com.syphan.practice.commonservice.security.BaseSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class BoardingHouseSecurityConfiguration extends BaseSecurityConfig {
    @Autowired
    private Environment environment;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(
                "/",
                "/favicon.ico",
                "/**/*.png",
                "/**/*.gif",
                "/**/*.svg",
                "/**/*.jpg",
                "/**/*.html",
                "/**/*.css",
                "/**/*.js",
                "/h2-console/**",
                "/swagger-resources/**",
                "/api-docs",
                "/v2/api-docs",
                "/webjars/**",
                "/static/**",
                "/actuator/**",
                "/api/v1/auth/sign-in",
                String.format(environment.getProperty("spring.boot.admin.context-path", "/registration-service"), "/**"),
                "/api/v1/users"
        ).permitAll();
        super.configure(http);
    }
}
