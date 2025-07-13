package api;

import dto.MovieDto;
import model.Movie;
import org.springframework.http.ResponseEntity;

public interface MoviesApi {

    ResponseEntity<MovieDto> add(MovieDto movie);

    ResponseEntity<MovieDto> update(MovieDto movie);

    ResponseEntity<MovieDto> delete(int movieId);

    ResponseEntity<MovieDto> get(int movieId);




}
