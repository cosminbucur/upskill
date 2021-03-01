package com.sda.patterns.creational.abstract_factory;

import com.sda.patterns.creational.abstract_factory.factory.GUIFactory;
import com.sda.patterns.creational.abstract_factory.factory.MacFactory;
import com.sda.patterns.creational.abstract_factory.factory.WinFactory;

public class DemoAbstractFactory {

    // client
    public static void main(String[] args) {
        // get factory type
        String os = "mac";
        GUIFactory factory = buildGUIFactory(os);
        Application application = new Application(factory);
        application.createUI();
        application.paintUI();
    }

    private static GUIFactory buildGUIFactory(String os) {
        GUIFactory factory;
        if (os.equals("win")) {
            factory = new WinFactory();
        } else if (os.equals("mac")) {
            factory = new MacFactory();
        } else {
            throw new IllegalArgumentException("os not supported");
        }
        return factory;
    }
}
