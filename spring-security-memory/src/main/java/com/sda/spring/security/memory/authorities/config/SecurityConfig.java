package com.sda.spring.security.memory.authorities.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // configure in memory auth with 3 users
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(passwordEncoder().encode("pass"))
                .authorities("ROLE_ADMIN", "READ_AUTHORITY", "WRITE_AUTHORITY")

                .and()
                .withUser("user")
                .password(passwordEncoder().encode("pass"))
                .roles("USER")

                .and()
                .withUser("manager")
                .password(passwordEncoder().encode("pass"))
                .authorities("ROLE_MANAGER", "READ_AUTHORITY");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/public").permitAll()

                // allow role admin and user
                .antMatchers("/api/role").hasAnyRole("ADMIN", "USER")

                // allow authority admin and manager
                .antMatchers("/api/authority").hasAuthority("READ_AUTHORITY")

                .and()
                .httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
