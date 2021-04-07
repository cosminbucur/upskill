package com.sda.spring.security.database.config;

import com.sda.spring.security.database.model.AppUser;
import com.sda.spring.security.database.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbInit {

    @Autowired
    private AppUserRepository appUserRepository;

    @Bean
    public CommandLineRunner initialData() {
        return args -> {
            AppUser admin = new AppUser("admin", "{noop}pass", "ADMIN");
            AppUser user = new AppUser("user", "{noop}pass", "USER");
            appUserRepository.save(admin);
            appUserRepository.save(user);
        };
    }
}
