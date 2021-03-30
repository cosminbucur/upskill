package com.sda.spring.aop;

import com.sda.spring.aop.config.AppConfig;
import com.sda.spring.aop.service.BookService;
import com.sda.spring.aop.service.VersionService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAOPApplication {


    private static BookService bookService;

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        VersionService versionService = context.getBean("versionService", VersionService.class);

        String version = versionService.getVersion();
        System.out.println("-------- " + version);

        bookService = context.getBean("bookService", BookService.class);

        testExecutionAspects();
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
}
