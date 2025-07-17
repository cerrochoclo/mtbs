package com.yk.att.mtbs.movies.api;

import com.yk.att.mtbs.movies.dto.ShowtimeDto;
import com.yk.att.mtbs.movies.mappers.ShowtimeMapper;
import com.yk.att.mtbs.movies.services.ValidationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.yk.att.mtbs.movies.services.ShowtimeService;
import org.springframework.web.server.ResponseStatusException;

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
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ShowtimeDto> add(@Valid @RequestBody ShowtimeDto showtime) {
        try {
            return ResponseEntity.ok(
                    showtimeMapper.toDto(showtimeService
                            .add(showtimeMapper.toModel(showtime))));
        }
        catch(ValidationException valExc) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, valExc.getMessage());
        }
    }

    @Override
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<ShowtimeDto> get(@Valid @PathVariable int id) {
        var showtime = showtimeService.get(id);
        if(null == showtime) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(showtimeMapper.toDto(showtime));
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<ShowtimeDto>> getAll() {
        return ResponseEntity.ok(showtimeService.getAll().stream().map(showtimeMapper::toDto).toList());
    }

    @Override
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/fetch")
    public ResponseEntity<List<ShowtimeDto>> fetchByMovieByTheatre(@RequestParam int movieId, @RequestParam int theatreId) {
        return ResponseEntity.ok(showtimeService.fetchByMovieByTheatre(movieId, theatreId)
                .stream().map(showtimeMapper::toDto).toList());
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public ResponseEntity<ShowtimeDto> update(@Valid @RequestBody ShowtimeDto showtime) {
        try {
            var updatedShowtime = showtimeService.update(showtimeMapper.toModel(showtime));
            if (null == updatedShowtime) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(showtimeMapper.toDto(updatedShowtime));
        }
        catch(ValidationException valExc) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, valExc.getMessage());
        }
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<ShowtimeDto> delete(@PathVariable int id) {
        boolean isDeleted = showtimeService.delete(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();  // 204 No Content
        } else {
            return ResponseEntity.notFound().build();  // 404 Not Found
        }
    }
}
