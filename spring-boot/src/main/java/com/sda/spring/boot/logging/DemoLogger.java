package com.sda.spring.boot.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoLogger {

    // live templates
    private static final Logger log = LoggerFactory.getLogger(DemoLogger.class);

    public static void main(String[] args) {
        int firstParam = 10;
        String secondParam = "issues";
        log.error("error message with {} {}", firstParam, secondParam);
        log.warn("warn message");
        log.info("info message");

        log.debug("debug message");
        log.trace("trace message");
    }
}
