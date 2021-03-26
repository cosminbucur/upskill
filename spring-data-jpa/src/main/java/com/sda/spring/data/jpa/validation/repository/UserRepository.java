package com.sda.spring.data.jpa.validation.repository;

import com.sda.spring.data.jpa.validation.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();
}
