package com.sda.spring.data.jpa.repositories.pagination;

import com.sda.spring.data.jpa.repositories.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonPagingAndSortingRepository extends
        PagingAndSortingRepository<Person, Long> {

    Page<Person> findByAge(int age, Pageable pageable);
}
