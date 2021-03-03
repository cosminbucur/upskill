package com.sda.spring.core.autowired;

import org.springframework.stereotype.Component;

@Component
public class SpellChecker {

    public void check() {
        System.out.println("check spelling");
    }
}
