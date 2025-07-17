package com.yk.att.mtbs.movies.services;

import com.yk.att.mtbs.movies.model.Showtime;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShowtimeService {

    Showtime get(int id);

    Showtime add(Showtime showtime) throws ValidationException;

    Showtime update(Showtime showtime) throws ValidationException;

    List<Showtime> getAll();

    List<Showtime> getByMovieByTheatre(Integer movieId, Integer theatreId);

    boolean delete(int id);
}
