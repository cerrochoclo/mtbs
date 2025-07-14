package com.yk.att.mtbs.movies.api;

import com.yk.att.mtbs.movies.dto.ShowtimeDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ShowtimeApi {

    ResponseEntity<ShowtimeDto> add(ShowtimeDto showtime);

    ResponseEntity<ShowtimeDto> get(int id);

    ResponseEntity<List<ShowtimeDto>> getAll();

    ResponseEntity<List<ShowtimeDto>> fetchByMovieByTheatre(int movieId, int theatreId);

    ResponseEntity<ShowtimeDto> update(ShowtimeDto showtime);

    ResponseEntity<ShowtimeDto> delete(int id);

}
