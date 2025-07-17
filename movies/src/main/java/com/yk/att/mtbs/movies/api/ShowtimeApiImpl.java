package com.yk.att.mtbs.movies.api;

import com.yk.att.mtbs.movies.dto.ShowtimeDto;
import com.yk.att.mtbs.movies.mappers.ShowtimeMapper;
import com.yk.att.mtbs.movies.services.ValidationException;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(ShowtimeApiImpl.class);


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
            logger.debug(valExc.getMessage());
            return ResponseEntity.status(HttpStatusCode.valueOf(409)).build();
        }
        catch(Exception exc) {
            logger.error(exc.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<ShowtimeDto> get(@Valid @PathVariable int id) {
        try {
            var showtime = showtimeService.get(id);
            if (null == showtime) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(showtimeMapper.toDto(showtime));
        }
        catch(Exception exc) {
            logger.error(exc.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<ShowtimeDto>> getAll() {
        try {
            return ResponseEntity.ok(showtimeService.getAll().stream().map(showtimeMapper::toDto).toList());
        }
        catch(Exception exc) {
            logger.error(exc.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/fetch")
    public ResponseEntity<List<ShowtimeDto>> fetchByMovieByTheatre(@RequestParam(value="movieId", required = false) Integer movieId, @RequestParam(value="theatreId", required = false) Integer theatreId) {
        try {
            return ResponseEntity.ok(showtimeService.getByMovieByTheatre(movieId, theatreId)
                    .stream().map(showtimeMapper::toDto).toList());
        }
        catch(Exception exc) {
            logger.error(exc.getMessage());
            return ResponseEntity.internalServerError().build();
        }
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
            logger.debug(valExc.getMessage());
            return ResponseEntity.status(HttpStatusCode.valueOf(409)).build();
        }
        catch(Exception exc) {
            logger.error(exc.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<ShowtimeDto> delete(@PathVariable int id) {
        try {
            boolean isDeleted = showtimeService.delete(id);
            if (isDeleted) {
                return ResponseEntity.noContent().build();  // 204 No Content
            } else {
                return ResponseEntity.notFound().build();  // 404 Not Found
            }
        }
        catch(Exception exc) {
            logger.error(exc.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
