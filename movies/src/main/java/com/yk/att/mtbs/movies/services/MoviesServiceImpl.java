package com.yk.att.mtbs.movies.services;

import com.yk.att.mtbs.movies.model.Movie;
import com.yk.att.mtbs.movies.persistence.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesServiceImpl implements MoviesService {

    private final MovieRepository movieRepository;
    private final JpaHelper<Movie> jpaHelper;

    @Autowired
    public MoviesServiceImpl(MovieRepository movieRepository, JpaHelper<Movie> jpaHelper) {
        this.movieRepository = movieRepository;
        this.jpaHelper = jpaHelper;
    }

    @Override
    public Movie get(int id) {
        return jpaHelper.getNonDeleted(id, movieRepository);
    }

    @Override
    public Movie add(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie update(Movie movie) {
        return jpaHelper.saveNonDeleted(movie, movieRepository);
    }

    @Override
    public boolean delete(int id) {
        return jpaHelper.softDelete(id, movieRepository);
    }

    @Override
    public List<Movie> getAll() {
        return jpaHelper.findAllNonDeleted(movieRepository);
    }
}
