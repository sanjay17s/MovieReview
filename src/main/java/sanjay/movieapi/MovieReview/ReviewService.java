package sanjay.movieapi.MovieReview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repository;

/*
    MongoTemplate mongoTemplate: This dependency injects an instance of MongoTemplate, which is a central class
    in Spring Data MongoDB that provides high-level methods for interacting with MongoDB. It allows you to
     perform operations like querying and updating documents directly using MongoDB's native query language.
  */

    @Autowired
    private MongoTemplate mongoTemplate;


    /*
        This method takes two parameters: reviewBody, which is the body of the review, and imdbId, which is
        the IMDb ID of the movie being reviewed.It first creates a new Review object using the provided reviewBody
        and inserts it into the database using the insert method provided by ReviewRepository. This method returns
        the newly created Review object.Then, it updates the corresponding Movie document in the database to
        include the newly created review. It does this using the update method provided by MongoTemplate.
        The matching method specifies the criteria for matching documents in the Movie collection.
        In this case, it looks for a document where the imdbId field matches the provided imdbId.
        The apply method applies the specified update operation to the matched document.
        In this case, it pushes (appends) the ID of the newly created review to the reviewIds
        array field in the Movie document.
     */
    public Review createReview(String reviewBody, String imdbId) {
        // Create a new Review object with the provided review body
        Review review = repository.insert(new Review(reviewBody));

        // Update the Movie document with the provided IMDb ID to include the new review
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review)).first();

        // Return the created review
        return review;
    }
}
