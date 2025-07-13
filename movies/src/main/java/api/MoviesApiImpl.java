package api;

import model.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movies")
public class MoviesApiImpl implements MoviesApi {
    @Override
    @PostMapping
    public ResponseEntity<Movie> add(Movie movie) {
        return null;
    }

    @Override
    @PutMapping
    public ResponseEntity<Movie> update(Movie movie) {
        return null;
    }

    @Override
    @DeleteMapping
    public ResponseEntity<Movie> delete(int movieId) {
        return null;
    }

    @Override
    @GetMapping
    public ResponseEntity<Movie> get(int movieId) {
        return null;
    }
}
