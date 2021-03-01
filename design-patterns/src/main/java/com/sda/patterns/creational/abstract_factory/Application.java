package com.sda.patterns.creational.abstract_factory;

import com.sda.patterns.creational.abstract_factory.button.Button;
import com.sda.patterns.creational.abstract_factory.checkbox.Checkbox;
import com.sda.patterns.creational.abstract_factory.factory.GUIFactory;

public class Application {

    private GUIFactory factory;
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        this.factory = factory;
    }

    public void createUI() {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paintUI() {
        button.paint();
        checkbox.paint();
    }
}
