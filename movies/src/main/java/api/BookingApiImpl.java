package api;

import dto.BookingDto;
import model.Booking;
import model.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/booking")
public class BookingApiImpl implements BookingApi {
    @Override
    @PostMapping
    public ResponseEntity<BookingDto> add(BookingDto booking) {
        return null;
    }

    @Override
    @GetMapping
    public ResponseEntity<BookingDto> get(int id) {
        return null;
    }
}
