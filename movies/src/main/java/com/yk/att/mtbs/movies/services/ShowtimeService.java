package com.yk.att.mtbs.movies.services;

import com.yk.att.mtbs.movies.model.Showtime;

import java.util.List;

public interface ShowtimeService {

    Showtime get(int id);

    Showtime add(Showtime showtime) throws ValidationException;

    Showtime update(Showtime showtime) throws ValidationException;

    List<Showtime> getAll();

    List<Showtime> fetchByMovieByTheatre(int movieId, int theatreId);

    boolean delete(int id);
}
