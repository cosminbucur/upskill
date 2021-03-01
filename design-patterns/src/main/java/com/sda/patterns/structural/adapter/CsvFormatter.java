package com.sda.patterns.structural.adapter;

public class CsvFormatter implements CsvFormattable {

    @Override
    public String formatText(String text) {
        return text.replace(".", ",");
    }
}
