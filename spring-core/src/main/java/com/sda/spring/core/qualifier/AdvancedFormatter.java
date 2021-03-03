package com.sda.spring.core.qualifier;

import org.springframework.stereotype.Component;

@Component("advFormatter")
public class AdvancedFormatter implements Formatter {

    @Override
    public String format() {
        System.out.println("advanced format");
        return "ok";
    }
}
