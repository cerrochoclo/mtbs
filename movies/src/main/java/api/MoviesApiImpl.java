package api;

import dto.MovieDto;
import model.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movies")
public class MoviesApiImpl implements MoviesApi {
    @Override
    @PostMapping
    public ResponseEntity<MovieDto> add(MovieDto movie) {
        return null;
    }

    @Override
    @PutMapping
    public ResponseEntity<MovieDto> update(MovieDto movie) {
        return null;
    }

    @Override
    @DeleteMapping
    public ResponseEntity<MovieDto> delete(int movieId) {
        return null;
    }

    @Override
    @GetMapping
    public ResponseEntity<MovieDto> get(int movieId) {
        return null;
    }
}
