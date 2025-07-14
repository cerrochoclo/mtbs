package com.yk.att.mtbs.movies.services.validation;

import com.yk.att.mtbs.movies.model.Showtime;
import com.yk.att.mtbs.movies.persistence.ShowtimeRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ValidationHelper {

    public List<ValidationError> validateShowtime(Showtime showtime, ShowtimeRepository repository) {
        List<ValidationError> valErrors = new ArrayList<>();
        if(!repository.findConflictingShowtimes(
                showtime.getTheatreId(),
                showtime.getStartTime(),
                showtime.getEndTime())
                .isEmpty()){
            valErrors.add(ValidationError.THEATRE_CONFLICTING_SHOWTIMES);
        }

        return valErrors;

    }
}
