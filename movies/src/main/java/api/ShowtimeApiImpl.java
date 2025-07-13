package api;

import model.Showtime;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShowtimeApiImpl implements ShowtimeApi {
    @Override
    @PostMapping
    public ResponseEntity<Showtime> add(Showtime showtime) {
        return null;
    }

    @Override
    @GetMapping
    public ResponseEntity<Showtime> get(int showTimeId) {
        return null;
    }

    @Override
    @PutMapping
    public ResponseEntity<Showtime> update(Showtime showtime) {
        return null;
    }

    @Override
    @DeleteMapping
    public ResponseEntity<Showtime> delete(int showtimeId) {
        return null;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Showtime>> fetchByMovieByTheatre(int movieId, int theatreId) {
        return null;
    }
}
