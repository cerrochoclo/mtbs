package com.yk.att.mtbs.movies.api;

import com.yk.att.mtbs.movies.dto.BookingDto;
import com.yk.att.mtbs.movies.mappers.BookingMapper;
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
import com.yk.att.mtbs.movies.services.BookingService;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
public class BookingApiImpl implements BookingApi {

    private final BookingService bookingService;
    private final BookingMapper bookingMapper;
    private static final Logger logger = LoggerFactory.getLogger(BookingApiImpl.class);


    @Autowired
    public BookingApiImpl(BookingService bookingService, BookingMapper bookingMapper) {
        this.bookingService = bookingService;
        this.bookingMapper = bookingMapper;
    }

    @Override
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<BookingDto> add(@Valid @RequestBody BookingDto booking) {
        try {
            logger.info("Received booking request: {}", booking);
            var createdBooking = bookingService.add(bookingMapper.toModel(booking));
            var createdBookingDto = bookingMapper.toDto(createdBooking);
            logger.info("Booking created with ID: {}", createdBookingDto.id());
            return ResponseEntity.status(HttpStatus.CREATED).body(createdBookingDto);
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
    public ResponseEntity<BookingDto> get(@PathVariable int id) {
        try {
            logger.debug("Fetching booking with ID: {}", id);
            var booking = bookingService.get(id);
            if (booking == null) {
                logger.warn("Booking not found with ID: {}", id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(null);
            }
            logger.info("Booking retrieved: {}", id);
            return ResponseEntity.ok(bookingMapper.toDto(booking));
        }
        catch(Exception exc) {
            logger.error(exc.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<BookingDto>> getAll() {
        try {
            logger.debug("Fetching all bookings");
            var bookings = bookingService.getAll().stream().map(bookingMapper::toDto).toList();
            logger.info("Retrieved {} bookings", bookings.size());
            return ResponseEntity.ok(bookings);
        }
        catch(Exception exc) {
            logger.error(exc.getMessage());
            return ResponseEntity.internalServerError().build();
        }

    }
}
