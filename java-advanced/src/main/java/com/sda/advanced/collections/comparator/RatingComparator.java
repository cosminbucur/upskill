package com.sda.advanced.collections.comparator;

import java.util.Comparator;

public class RatingComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie first, Movie second) {
//        return first.getRating() - second.getRating();
        return Integer.compare(first.getRating(), second.getRating());
    }
}
