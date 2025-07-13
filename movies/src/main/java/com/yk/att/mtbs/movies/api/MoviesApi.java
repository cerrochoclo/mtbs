package com.yk.att.mtbs.movies.api;

import com.yk.att.mtbs.movies.dto.MovieDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MoviesApi {

    ResponseEntity<MovieDto> add(MovieDto movie);

    ResponseEntity<MovieDto> update(MovieDto movie);

    ResponseEntity<MovieDto> delete(int movieId);

    ResponseEntity<MovieDto> get(int movieId);

    ResponseEntity<List<MovieDto>> getAll();




}
