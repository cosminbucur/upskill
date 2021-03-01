package com.sda.patterns.structural.adapter;

public class CsvAdapter implements TextFormattable {

    private CsvFormattable csvFormatter;

    public CsvAdapter(CsvFormattable csvFormatter) {
        this.csvFormatter = csvFormatter;
    }

    @Override
    public String formatText(String text) {
        return csvFormatter.formatText(text);
    }
}
