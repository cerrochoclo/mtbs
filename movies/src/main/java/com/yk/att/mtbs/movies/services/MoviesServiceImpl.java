package com.yk.att.mtbs.movies.services;

import com.yk.att.mtbs.movies.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yk.att.mtbs.movies.persistence.MovieRepository;

@Service
public class MoviesServiceImpl implements MoviesService {

    private final MovieRepository movieRepository;

    @Autowired
    public MoviesServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie get(int id) {
        return movieRepository.getReferenceById(id);
    }

    @Override
    public Movie add(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie update(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public boolean delete(int id) {
        movieRepository.deleteById(id);
        return true;
    }
}
