package api;

import dto.MovieDto;
import mappers.MovieMapper;
import model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.MoviesService;

@RestController
@RequestMapping("/api/movies")
public class MoviesApiImpl implements MoviesApi {

    private final MoviesService moviesService;
    private final MovieMapper movieMapper;


    @Autowired
    public MoviesApiImpl(MoviesService moviesService, MovieMapper movieMapper) {
        this.moviesService = moviesService;
        this.movieMapper = movieMapper;
    }

    @Override
    @PostMapping
    public ResponseEntity<MovieDto> add(@RequestBody MovieDto movie) {
        return ResponseEntity.ok(
                movieMapper.toDto(moviesService
                                .add(movieMapper.toModel(movie))));
    }

    @Override
    @PutMapping
    public ResponseEntity<MovieDto> update(@RequestBody MovieDto movie) {
        return ResponseEntity.ok(
                movieMapper.toDto(moviesService
                        .update(movieMapper.toModel(movie))));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<MovieDto> delete(@PathVariable int id) {
        return ResponseEntity.ok(
                movieMapper.toDto(moviesService
                        .delete(id)));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> get(@PathVariable int id) {
        return ResponseEntity.ok(
                movieMapper.toDto(moviesService
                        .get(id)));
    }
}
