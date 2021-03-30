package com.sda.spring.aop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private static final Logger log = LoggerFactory.getLogger(BookService.class);

    // find all
    public List<String> findAll() {
        log.info("in findAll()");
        return new ArrayList<>();
    }

    // find by id
    public String findById(Long id) {
        log.info("in findById()");
        return "book";
    }

    // exists
    public boolean exists(Long id) {
        log.info("in exists()");
        if (id < 0) {
            throw new IllegalStateException("wrong id");
        }
        return false;
    }

    // delete
    public void delete(Long id) {
        log.info("in delete()");
    }
}
