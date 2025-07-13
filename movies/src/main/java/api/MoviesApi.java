package api;

import model.Movie;
import org.springframework.http.ResponseEntity;

public interface MoviesApi {

    ResponseEntity<Movie> add(Movie movie);

    ResponseEntity<Movie> update(Movie movie);

    ResponseEntity<Movie> delete(int movieId);

    ResponseEntity<Movie> get(int movieId);




}
