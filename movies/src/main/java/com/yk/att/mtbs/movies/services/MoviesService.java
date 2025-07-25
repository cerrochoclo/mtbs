package com.yk.att.mtbs.movies.services;

import com.yk.att.mtbs.movies.model.Movie;

import java.util.List;

public interface MoviesService {

    Movie get(int id);

    Movie add(Movie movie);

    Movie update(Movie movie);

    boolean delete(int id);

    List<Movie> getAll();


}
