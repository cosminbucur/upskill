package com.sda.advanced.collections.comparator;

import java.util.Comparator;

public class TitleComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie first, Movie second) {
        return first.getTitle().compareTo(second.getTitle());
    }
}
