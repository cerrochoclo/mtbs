package com.yk.att.mtbs.movies.api;

import com.yk.att.mtbs.movies.dto.MovieDto;
import com.yk.att.mtbs.movies.mappers.MovieMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.yk.att.mtbs.movies.services.MoviesService;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MoviesApiImpl implements MoviesApi {

    private final MoviesService moviesService;
    private final MovieMapper movieMapper;
    private static final Logger logger = LoggerFactory.getLogger(MoviesApiImpl.class);


    @Autowired
    public MoviesApiImpl(MoviesService moviesService, MovieMapper movieMapper) {
        this.moviesService = moviesService;
        this.movieMapper = movieMapper;
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<MovieDto> add(@Valid@RequestBody MovieDto movie) {
        try {
            return ResponseEntity.ok(
                    movieMapper.toDto(moviesService
                            .add(movieMapper.toModel(movie))));
        }
        catch(Exception exc) {
            logger.error(exc.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public ResponseEntity<MovieDto> update(@Valid @RequestBody MovieDto movie) {
        try {
            var updatedMovie = moviesService.update(movieMapper.toModel(movie));

            return ResponseEntity.ok(movieMapper.toDto(updatedMovie));
        }
        catch(EntityNotFoundException enfe) {
            logger.debug(enfe.getMessage());
            return ResponseEntity.notFound().build();
        }
        catch(Exception exc) {
            logger.error(exc.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<MovieDto> delete(@PathVariable int id) {
        try {
            boolean isDeleted = moviesService.delete(id);
            if (isDeleted) {
                return ResponseEntity.noContent().build();  // 204 No Content
            } else {
                return ResponseEntity.notFound().build();  // 404 Not Found
            }
        }
        catch(Exception exc) {
            logger.error(exc.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> get(@PathVariable int id) {
        try {
            var movie = moviesService.get(id);
            if (null == movie) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(movieMapper.toDto(movie));
        }
        catch(Exception exc) {
            logger.error(exc.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<MovieDto>> getAll() {
        try {
            return ResponseEntity.ok(moviesService.getAll().stream().map(movieMapper::toDto).toList());
        }
        catch(Exception exc) {
            logger.error(exc.getMessage());
            return ResponseEntity.internalServerError().build();
        }

    }
}
