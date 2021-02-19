package com.sda.advanced.collections.comparator;

public class Movie {

    private String title;
    private int rating;
    private int year;

    public Movie(String title, int rating, int year) {
        this.title = title;
        this.rating = rating;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", rating=" + rating +
                ", year=" + year +
                '}';
    }
}
