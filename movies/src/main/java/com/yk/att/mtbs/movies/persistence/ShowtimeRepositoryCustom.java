package com.yk.att.mtbs.movies.persistence;

import com.yk.att.mtbs.movies.model.Showtime;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface ShowtimeRepositoryCustom {

    List<Showtime> findConflictingShowtimes(int theatreId, OffsetDateTime startTime, OffsetDateTime endTime);
}
