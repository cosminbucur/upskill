package com.sda.ratings.resource;

import com.sda.ratings.model.Rating;
import com.sda.ratings.model.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/ratings")
@RestController
public class RatingResource {

    // get rating by bookId
    @GetMapping("/{bookId}")
    public Rating getRating(@PathVariable("bookId") String bookId) {
        return new Rating(bookId, 5);
    }

    // get list of ratings by user id
    @GetMapping("/users/{userId}")
    public UserRating getUserRatings(@PathVariable("userId") String userId) {
        List<Rating> ratings = Arrays.asList(
                new Rating("111", 5),
                new Rating("222", 4));

        UserRating userRating = new UserRating();
        userRating.setRatings(ratings);
        return userRating;
    }
}
