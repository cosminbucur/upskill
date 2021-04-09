package com.sda.catalog.resource;

import com.sda.catalog.model.Book;
import com.sda.catalog.model.CatalogItem;
import com.sda.catalog.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/catalog")
@RestController
public class BookCatalogResource {

//    public static final String BOOKS_RESOURCE = "http://localhost:8082/books/";
//    public static final String RATINGS_RESOURCE = "http://localhost:8083/ratings/";

    // from eureka
    public static final String BOOKS_RESOURCE = "http://book-info-service/books/";
    public static final String RATINGS_RESOURCE = "http://ratings-data-service/ratings/";

    private final RestTemplate restTemplate;

    @Autowired
    public BookCatalogResource(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        // get all rated books ids, call ratings-data-service
        UserRating ratings = restTemplate.getForObject(RATINGS_RESOURCE + "/users/" + userId, UserRating.class);

        return ratings.getRatings().stream()
                .map(rating -> {
                    // get book info
                    Book book = restTemplate.getForObject(BOOKS_RESOURCE + rating.getBookId(), Book.class);

                    // create catalog item
                    return new CatalogItem(book.getBookId(), book.getTitle(), book.getAuthor(), rating.getRating());
                })
                .collect(Collectors.toList());
    }
}
