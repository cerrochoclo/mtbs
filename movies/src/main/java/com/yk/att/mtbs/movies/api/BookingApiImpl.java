package com.yk.att.mtbs.movies.api;

import com.yk.att.mtbs.movies.dto.BookingDto;
import com.yk.att.mtbs.movies.mappers.BookingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.yk.att.mtbs.movies.services.BookingService;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
public class BookingApiImpl implements BookingApi {

    private final BookingService bookingService;
    private final BookingMapper bookingMapper;


    @Autowired
    public BookingApiImpl(BookingService bookingService, BookingMapper bookingMapper) {
        this.bookingService = bookingService;
        this.bookingMapper = bookingMapper;
    }

    @Override
    @PostMapping
    public ResponseEntity<BookingDto> add(@RequestBody BookingDto booking) {
        return ResponseEntity.ok(bookingMapper.toDto(bookingService.add(bookingMapper.toModel(booking))));
    }

    @Override
    @GetMapping("{id}")
    public ResponseEntity<BookingDto> get(@PathVariable int id) {
        return ResponseEntity.ok(bookingMapper.toDto(bookingService.get(id)));
    }

    @Override
    public ResponseEntity<List<BookingDto>> getAll() {
        return ResponseEntity.ok(bookingService.getAll().stream().map(bookingMapper::toDto).toList());

    }
}
