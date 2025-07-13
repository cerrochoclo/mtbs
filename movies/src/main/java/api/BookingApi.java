package api;

import dto.BookingDto;
import dto.MovieDto;
import model.Booking;
import model.Movie;
import org.springframework.http.ResponseEntity;

public interface BookingApi {

    ResponseEntity<BookingDto> add(BookingDto booking);

    ResponseEntity<BookingDto> get(int id);

}
