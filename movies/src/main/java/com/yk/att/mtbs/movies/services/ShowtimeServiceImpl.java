package com.yk.att.mtbs.movies.services;

import com.yk.att.mtbs.movies.model.Showtime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yk.att.mtbs.movies.persistence.ShowtimeRepository;

import java.util.List;

@Service
public class ShowtimeServiceImpl implements ShowtimeService {

    private final ShowtimeRepository showtimeRepository;

    @Autowired
    public ShowtimeServiceImpl(ShowtimeRepository showtimeRepository) {
        this.showtimeRepository = showtimeRepository;
    }

    @Override
    public Showtime get(int id) {
        return showtimeRepository.getReferenceById(id);
    }

    @Override
    public Showtime add(Showtime showtime) {
        return showtimeRepository.save(showtime);
    }

    @Override
    public List<Showtime> getAll() {
        return showtimeRepository.findAll();
    }

    @Override
    public List<Showtime> fetchByMovieByTheatre(int movieId, int theatreId) {
        return List.of();
    }
}
