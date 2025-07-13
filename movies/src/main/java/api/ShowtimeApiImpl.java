package api;

import dto.ShowtimeDto;
import mappers.ShowtimeMapper;
import model.Showtime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.ShowtimeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/showtime")
public class ShowtimeApiImpl implements ShowtimeApi {

    private final ShowtimeService showtimeService;
    private final ShowtimeMapper showtimeMapper;


    @Autowired
    public ShowtimeApiImpl(ShowtimeService showtimeService, ShowtimeMapper showtimeMapper) {
        this.showtimeService = showtimeService;
        this.showtimeMapper = showtimeMapper;
    }

    @Override
    @PostMapping
    public ResponseEntity<ShowtimeDto> add(ShowtimeDto showtime) {
        return ResponseEntity.ok(
                showtimeMapper.toDto(showtimeService
                        .add(showtimeMapper.toModel(showtime))));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ShowtimeDto> get(@PathVariable int id) {
        return ResponseEntity.ok(
                showtimeMapper.toDto(showtimeService
                        .get(id)));
    }

    @Override
    @GetMapping("/fetch")
    public ResponseEntity<List<ShowtimeDto>> fetchByMovieByTheatre(@RequestParam int movieId, @RequestParam int theatreId) {
        return ResponseEntity.ok(showtimeService.fetchByMovieByTheatre(movieId, theatreId)
                .stream().map(showtimeMapper::toDto).toList());
    }
}
