package com.yk.att.mtbs.movies.api;

import com.yk.att.mtbs.movies.dto.MovieDto;
import com.yk.att.mtbs.movies.mappers.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.yk.att.mtbs.movies.services.MoviesService;

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
        boolean isDeleted = moviesService.delete(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();  // 204 No Content
        } else {
            return ResponseEntity.notFound().build();  // 404 Not Found
        }
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> get(@PathVariable int id) {
        return ResponseEntity.ok(
                movieMapper.toDto(moviesService
                        .get(id)));
    }
}
