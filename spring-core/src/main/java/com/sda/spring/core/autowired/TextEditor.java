package com.sda.spring.core.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TextEditor {

    // field injection
    @Autowired
    private SpellChecker spellChecker;

    private TextFormatter textFormatter;

    private ImageConverter imageConverter;

    // constructor injection
    @Autowired
    public TextEditor(ImageConverter imageConverter) {
        this.imageConverter = imageConverter;
    }

    // setter injection
    @Autowired
    public void setTextFormatter(TextFormatter textFormatter) {
        this.textFormatter = textFormatter;
    }

    public void spellCheck() {
        // delegation
        spellChecker.check();
    }

    public void format() {
        textFormatter.check();
    }

    public void convertImage() {
        imageConverter.convert();
    }
}
