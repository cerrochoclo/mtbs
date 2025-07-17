package com.yk.att.mtbs.movies.persistence;

import com.yk.att.mtbs.movies.model.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Integer>, ShowtimeRepositoryCustom {
    @Query("SELECT s FROM Showtime s WHERE (:movieId IS NULL OR s.movieId = :movieId) AND (:theatreId IS NULL OR s.theatreId = :theatreId)")
    List<Showtime> findByMovieAndTheatre(@Param("movieId") Integer movieId, @Param("theatreId") Integer theatreId);
}
