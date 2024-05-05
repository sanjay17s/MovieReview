package sanjay.movieapi.MovieReview;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private FilmRepository filmRepository;

    public List<Movie> getAllMovies() {
        return filmRepository.findAll();
    }

    public Optional<Movie> findMovieByImdbId(String id) {
        return filmRepository.findByImdbId(id);
    }
}
