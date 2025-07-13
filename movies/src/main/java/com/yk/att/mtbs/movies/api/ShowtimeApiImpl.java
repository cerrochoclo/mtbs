package com.yk.att.mtbs.movies.api;

import com.yk.att.mtbs.movies.dto.ShowtimeDto;
import com.yk.att.mtbs.movies.mappers.ShowtimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.yk.att.mtbs.movies.services.ShowtimeService;

import java.util.List;

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
    public ResponseEntity<ShowtimeDto> add(@RequestBody ShowtimeDto showtime) {
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
