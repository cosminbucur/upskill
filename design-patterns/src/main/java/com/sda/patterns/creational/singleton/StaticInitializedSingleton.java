package com.sda.patterns.creational.singleton;

public class StaticInitializedSingleton {

    private static StaticInitializedSingleton instance;

    static {
        try {
            instance = new StaticInitializedSingleton();
        } catch (Exception e) {
            throw new RuntimeException("failed to create singleton");
        }
    }

    private StaticInitializedSingleton() {

    }

    public static StaticInitializedSingleton getInstance() {
        return instance;
    }
}
