package com.yk.att.mtbs.movies.persistence;

import com.yk.att.mtbs.movies.model.Showtime;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;


@Repository
public class ShowtimeRepositoryCustomImpl implements ShowtimeRepositoryCustom {



    @PersistenceContext
    private EntityManager showtimeContextManager;

    @Override
    public List<Showtime> findConflictingShowtimes(int theatreId, OffsetDateTime startTime, OffsetDateTime endTime) {
        String query = """
                select s
                from Showtime s
                where s.theatreId = :theatreId and
                 (:startTime BETWEEN s.startTime AND s.endTime or
                 :endTime BETWEEN s.startTime AND s.endTime)
                """;
        return showtimeContextManager.createQuery(query, Showtime.class)
                .setParameter("startTime", startTime)
                .setParameter("endTime", endTime)
                .setParameter("theatreId", theatreId)
                .getResultList();
    }
}
