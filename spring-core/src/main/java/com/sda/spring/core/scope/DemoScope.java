package com.sda.spring.core.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoScope {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ScopeConfig.class);

        createSingleton(context);
        createPrototype(context);
    }

    private static void createPrototype(ApplicationContext context) {
        PrototypeService prototypeService1 = context.getBean("prototypeService", PrototypeService.class);
        PrototypeService prototypeService2 = context.getBean("prototypeService", PrototypeService.class);
        System.out.println("prototypeService " + prototypeService1);
        System.out.println("prototypeService " + prototypeService2);
    }

    private static void createSingleton(ApplicationContext context) {
        SingletonService singletonService1 = context.getBean("singletonService", SingletonService.class);
        SingletonService singletonService2 = context.getBean("singletonService", SingletonService.class);
        System.out.println("singletonService " + singletonService1);
        System.out.println("singletonService " + singletonService2);
    }
}
