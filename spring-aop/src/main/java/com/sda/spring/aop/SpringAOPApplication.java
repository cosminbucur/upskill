package com.sda.spring.aop;

import com.sda.spring.aop.config.AppConfig;
import com.sda.spring.aop.service.BookService;
import com.sda.spring.aop.service.OutputService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAOPApplication {

    private static BookService bookService;
    private static OutputService outputService;

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        bookService = context.getBean("bookService", BookService.class);
        outputService = context.getBean("outputService", OutputService.class);

//        testExecutionAspects();
        testAnnotationAspect();
    }

    private static void testExecutionAspects() {
        bookService.findAll();
        bookService.findById(1L);

        try {
            bookService.exists(-1L);
        } catch (Exception e) {
            System.out.println("it's ok");
        }

        bookService.delete(1L);
    }

    private static void testAnnotationAspect() {
        outputService.generateOutput();
        outputService.generateOutput();
    }
}
