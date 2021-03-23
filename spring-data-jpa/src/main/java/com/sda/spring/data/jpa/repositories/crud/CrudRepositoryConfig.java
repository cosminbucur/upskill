package com.sda.spring.data.jpa.repositories.crud;

import com.sda.spring.data.jpa.repositories.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CrudRepositoryConfig {

    private static final Logger log = LoggerFactory.getLogger(CrudRepositoryConfig.class);

    @Autowired
    public PersonCrudRepository personCrudRepository;

    @Bean
    public CommandLineRunner crudData() {
        return args -> {
            testCrudMethods();
        };
    }

    private void testCrudMethods() {
        // create
        personCrudRepository.save(new Person("paul", 25));
        personCrudRepository.save(new Person("ana", 30));

        // read

        // custom find
        Person paul = personCrudRepository.findByName("paul")
                .orElseThrow(() -> new RuntimeException("person not found"));

        personCrudRepository.findAll()
                .forEach(person -> log.info("person: {}", person));

        boolean existsById = personCrudRepository.existsById(paul.getId());
        log.info("paul exists by id: {}", existsById);

        // update
        paul.setAge(35);
        personCrudRepository.save(paul);

        // delete
        long count = personCrudRepository.count();
        log.info("count before delete: {}", count);

        personCrudRepository.deleteById(paul.getId());

        personCrudRepository.deleteAll();
    }

}
