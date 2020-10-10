package com.immfly.filghtinfo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        AuthExceptionHandler handler = new AuthExceptionHandler();
        http
                .exceptionHandling()
                .authenticationEntryPoint(handler)
                .accessDeniedHandler(handler)
                .and()
                .httpBasic().disable()
                .formLogin(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .cors()
                .and()
                .authorizeRequests()
                .anyRequest()
                .hasAuthority("SCOPE_ADMIN")
                .and()
                .oauth2ResourceServer().jwt();
    }
}
