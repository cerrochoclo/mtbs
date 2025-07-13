package api;

import dto.ShowtimeDto;
import model.Showtime;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ShowtimeApi {

    ResponseEntity<ShowtimeDto> add(ShowtimeDto showtime);

    ResponseEntity<ShowtimeDto> get(int showTimeId);

    ResponseEntity<ShowtimeDto> update(ShowtimeDto showtime);

    ResponseEntity<ShowtimeDto> delete(int showtimeId);

    ResponseEntity<List<ShowtimeDto>> fetchByMovieByTheatre(int movieId, int theatreId);
}
