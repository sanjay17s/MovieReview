package sanjay.movieapi.MovieReview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private FilmRepository filmRepository;

    public List<Movie> getAllMovies() {
        return filmRepository.findAll();
    }
}
