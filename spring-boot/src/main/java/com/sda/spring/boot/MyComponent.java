package com.sda.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {

    private static final Logger log = LoggerFactory.getLogger(MyComponent.class);

    public void complexOperation() {
        log.info("in complex operation");
    }
}
