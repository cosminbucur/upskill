package com.sda.spring.data.jpa.repositories.pagination;

import com.sda.spring.data.jpa.repositories.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Configuration
public class PagingAndSortingRepositoryConfig {

    private static final Logger log = LoggerFactory.getLogger(PagingAndSortingRepositoryConfig.class);

    @Autowired
    public PersonPagingAndSortingRepository repository;

    // run code after application starts
    @Bean
    public CommandLineRunner pagingAndSortingData() {
        return args -> {
            loadData();
            paginate();
            sort();
            paginateAndSort();
        };
    }

    private void paginate() {
        // interface pageable - pagination info
        // abstract page request - abstract class
        // page request - implementation

        // first page with 2 people
        Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
        Pageable secondPageWith1Element = PageRequest.of(1, 1);

        Page<Person> page = repository.findAll(firstPageWithTwoElements);
        printPageContent(page);

        Page<Person> peopleAge32Page = repository.findByAge(32, firstPageWithTwoElements);
        printPageContent(peopleAge32Page);
    }

    private void sort() {
        Sort sort = Sort.by("name");
        Iterable<Person> sortedPeopleByName = repository.findAll(sort);
        sortedPeopleByName.forEach(person -> log.info("person: {}", person));
    }

    private void paginateAndSort() {
        // people sorted by name
        Pageable sortByName = PageRequest.of(0, 5, Sort.by("name"));
        Page<Person> peopleSortedByName = repository.findAll(sortByName);

        // sorted by age descending
        Pageable sortByAgeDescending = PageRequest.of(0, 4, Sort.by("age").descending());
        Page<Person> peopleSortedByAgeDescending = repository.findAll(sortByAgeDescending);

        // sorted by age descending and name ascending
        Pageable sortByAgeDescendingAndNameAscending = PageRequest.of(0, 5,
                Sort.by("age").descending()
                        .and(Sort.by("name")));
        Page<Person> peopleSortedByAgeDescendingAndNameAscending = repository.findAll(sortByAgeDescendingAndNameAscending);

        printPageContent(peopleSortedByName);
        printPageContent(peopleSortedByAgeDescending);
        printPageContent(peopleSortedByAgeDescendingAndNameAscending);
    }

    private void printPageContent(Page<Person> page) {
        page.getContent()
                .forEach(person -> log.info("person: {}", person));
    }

    private void loadData() {
        repository.save(new Person("paul", 32));
        repository.save(new Person("alina", 28));
        repository.save(new Person("kazimir", 34));
        repository.save(new Person("lidia", 32));
        repository.save(new Person("violeta", 32));
    }

}
