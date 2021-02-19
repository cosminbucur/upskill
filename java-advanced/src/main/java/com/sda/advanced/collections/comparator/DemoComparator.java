package com.sda.advanced.collections.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DemoComparator {

    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();

        movies.add(new Movie("movie 1", 2, 1897));
        movies.add(new Movie("movie 3", 1, 1977));
        movies.add(new Movie("movie 2", 3, 1998));

        System.out.println(movies);
        Collections.sort(movies, new TitleComparator());
        Collections.sort(movies, new RatingComparator());
        Collections.reverse(movies);
        System.out.println(movies);
    }
}
