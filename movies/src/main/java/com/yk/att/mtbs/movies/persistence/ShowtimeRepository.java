package com.yk.att.mtbs.movies.persistence;

import com.yk.att.mtbs.movies.model.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Integer>, ShowtimeRepositoryCustom {
}
