package com.sda.spring.boot.rest.exception;

public class DuplicateBookException extends RuntimeException {

    public DuplicateBookException(String message) {
        super(message);
    }
}
