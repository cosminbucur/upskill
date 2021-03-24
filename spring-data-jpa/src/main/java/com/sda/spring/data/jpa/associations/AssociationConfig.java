package com.sda.spring.data.jpa.associations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AssociationConfig {

    private static final Logger log = LoggerFactory.getLogger(AssociationConfig.class);

    @Autowired
    private FatherRepository fatherRepository;

    @Bean
    public CommandLineRunner associationsData() {
        // use one line lambda
        return args -> testAssociations();
    }

    private void testAssociations() {
        Father father = new Father("father");

        Son son1 = new Son("son1");
        Son son2 = new Son("son2");

        father.addSon(son1);
        father.addSon(son2);

        fatherRepository.save(father);

        log.info("father count: {}", fatherRepository.count());
    }
}
