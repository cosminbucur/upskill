package com.sda.patterns.creational.singleton;

public class DemoSingleton {

    public static void main(String[] args) {
        EagerInitializedSingleton singleton = EagerInitializedSingleton.getInstance();
        LazyInitializedSingleton lazyInitializedSingleton = LazyInitializedSingleton.getInstance();
        StaticInitializedSingleton staticInitializedSingleton = StaticInitializedSingleton.getInstance();
        BillPughSingleton billPughSingleton = BillPughSingleton.getInstance();
    }
}
