package api;

import dto.ShowtimeDto;
import model.Showtime;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShowtimeApiImpl implements ShowtimeApi {
    @Override
    @PostMapping
    public ResponseEntity<ShowtimeDto> add(ShowtimeDto showtime) {
        return null;
    }

    @Override
    @GetMapping
    public ResponseEntity<ShowtimeDto> get(int showTimeId) {
        return null;
    }

    @Override
    @PutMapping
    public ResponseEntity<ShowtimeDto> update(ShowtimeDto showtime) {
        return null;
    }

    @Override
    @DeleteMapping
    public ResponseEntity<ShowtimeDto> delete(int showtimeId) {
        return null;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<ShowtimeDto>> fetchByMovieByTheatre(int movieId, int theatreId) {
        return null;
    }
}
