package api;

import model.Showtime;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ShowtimeApi {

    ResponseEntity<Showtime> add(Showtime showtime);

    ResponseEntity<Showtime> get(int showTimeId);

    ResponseEntity<Showtime> update(Showtime showtime);

    ResponseEntity<Showtime> delete(int showtimeId);

    ResponseEntity<List<Showtime>> fetchByMovieByTheatre(int movieId, int theatreId);
}
