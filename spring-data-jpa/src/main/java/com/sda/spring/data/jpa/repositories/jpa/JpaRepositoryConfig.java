package com.sda.spring.data.jpa.repositories.jpa;

import com.sda.spring.data.jpa.repositories.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Configuration
public class JpaRepositoryConfig {

    @Autowired
    public PersonJpaRepository repository;

    @Bean
    public CommandLineRunner jpaData() {
        return args -> {
            loadData();

            // get id of first person
            Long firstPersonId = repository.findAll().get(0).getId();

            Person existingPerson = repository.getOne(firstPersonId);

            Pageable firstTwoPeoplePage = PageRequest.of(0, 2);
            Page<Person> firstTwoPeople = repository.findAll(firstTwoPeoplePage);

            repository.deleteInBatch(firstTwoPeople);

            repository.deleteAllInBatch();
        };
    }

    private void loadData() {
        repository.save(new Person("paul", 32));
        repository.save(new Person("alina", 28));
        repository.save(new Person("kazimir", 34));
        repository.save(new Person("lidia", 32));
        repository.save(new Person("violeta", 32));
    }

}
