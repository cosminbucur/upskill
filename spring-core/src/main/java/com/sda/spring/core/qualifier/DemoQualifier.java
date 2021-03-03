package com.sda.spring.core.qualifier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoQualifier {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(QualifierConfig.class);

        FormatService formatService = context.getBean("formatService", FormatService.class);
        formatService.run();
    }
}
