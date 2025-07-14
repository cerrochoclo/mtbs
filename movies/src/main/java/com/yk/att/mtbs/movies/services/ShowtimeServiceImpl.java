package com.yk.att.mtbs.movies.services;

import com.yk.att.mtbs.movies.model.Showtime;
import com.yk.att.mtbs.movies.services.validation.ValidationError;
import com.yk.att.mtbs.movies.services.validation.ValidationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yk.att.mtbs.movies.persistence.ShowtimeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShowtimeServiceImpl implements ShowtimeService {

    private final ShowtimeRepository showtimeRepository;
    private final JpaHelper<Showtime> jpaHelper;
    private final ValidationHelper validationHelper;

    @Autowired
    public ShowtimeServiceImpl(ShowtimeRepository showtimeRepository, JpaHelper<Showtime> jpaHelper, ValidationHelper validationHelper) {
        this.showtimeRepository = showtimeRepository;
        this.jpaHelper = jpaHelper;
        this.validationHelper = validationHelper;
    }

    @Override
    public Showtime get(int id) {
        return jpaHelper.getNonDeleted(id, showtimeRepository);
    }

    @Override
    public Showtime add(Showtime showtime) throws ValidationException {
        var validationErrors = validationHelper.validateShowtime(showtime, showtimeRepository);
        if(validationErrors.isEmpty()) {
            return showtimeRepository.save(showtime);
        }
        throw new ValidationException(validationErrors.stream().map(ValidationError::getMessage).collect(Collectors.joining(";")));
    }

    @Override
    public Showtime update(Showtime showtime) throws ValidationException {
        var validationErrors = validationHelper.validateShowtime(showtime, showtimeRepository);
        if(validationErrors.isEmpty()) {
            return jpaHelper.saveNonDeleted(showtime, showtimeRepository);
        }
        throw new ValidationException(validationErrors.stream().map(ValidationError::getMessage).collect(Collectors.joining(";")));

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
