package sanjay.movieapi.MovieReview;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


/*

 @Document(collection = "movies"): This annotation is from Spring Data MongoDB and is used to indicate
that a class is a MongoDB document and should be persisted in the specified collection.
In this case, documents of this class will be stored in the "movies" collection.

@Data: This is a Lombok annotation that automatically generates getter and setter methods, toString(),
 equals(), and hashCode() methods for the annotated class.

@AllArgsConstructor: This Lombok annotation generates a constructor with arguments for all fields in the class.

@NoArgsConstructor: This Lombok annotation generates a no-argument constructor for the class.*/

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> backdrops;
    private List<String> genres;

}