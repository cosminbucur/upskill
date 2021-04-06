package com.sda.spring.security.memory.roles.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // how to authenticate
    // configure 2 users in memory
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()

                .withUser("admin")
                .password("{noop}pass")
                // ROLE_ will be appended
                .roles("ADMIN")

                .and()

                .withUser("user")
                .password("{noop}pass")
                .roles("USER");

    }

    // define authorization
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/public").permitAll()

                .antMatchers("/api/admin").hasRole("ADMIN")

                .and()
                // use basic authentication
                .httpBasic();
    }
}
