package com.yk.att.mtbs.movies.services;

import com.yk.att.mtbs.movies.model.Showtime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yk.att.mtbs.movies.persistence.ShowtimeRepository;

import java.util.List;

@Service
public class ShowtimeServiceImpl implements ShowtimeService {

    private final ShowtimeRepository showtimeRepository;
    private final JpaHelper<Showtime> jpaHelper;

    @Autowired
    public ShowtimeServiceImpl(ShowtimeRepository showtimeRepository, JpaHelper<Showtime> jpaHelper) {
        this.showtimeRepository = showtimeRepository;
        this.jpaHelper = jpaHelper;
    }

    @Override
    public Showtime get(int id) {
        return jpaHelper.getNonDeleted(id, showtimeRepository);
    }

    @Override
    public Showtime add(Showtime showtime) {
        return showtimeRepository.save(showtime);
    }

    @Override
    public Showtime update(Showtime showtime) {
        return jpaHelper.saveNonDeleted(showtime, showtimeRepository);

    }

    @Override
    public List<Showtime> getAll() {
        return jpaHelper.findAllNonDeleted(showtimeRepository);
    }

    @Override
    public List<Showtime> fetchByMovieByTheatre(int movieId, int theatreId) {
        return List.of();
    }

    @Override
    public boolean delete(int id) {
        return jpaHelper.softDelete(id, showtimeRepository);
    }
}
