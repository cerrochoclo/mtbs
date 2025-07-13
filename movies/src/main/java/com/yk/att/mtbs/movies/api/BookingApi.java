package com.yk.att.mtbs.movies.api;

import com.yk.att.mtbs.movies.dto.BookingDto;
import org.springframework.http.ResponseEntity;

public interface BookingApi {

    ResponseEntity<BookingDto> add(BookingDto booking);

    ResponseEntity<BookingDto> get(int id);

}
