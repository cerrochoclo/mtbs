package api;

import dto.BookingDto;
import mappers.BookingMapper;
import model.Booking;
import model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.BookingService;

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
    public ResponseEntity<BookingDto> add(BookingDto booking) {
        return ResponseEntity.ok(bookingService.add(bookingMapper.toModel(booking)));
    }

    @Override
    @GetMapping
    public ResponseEntity<BookingDto> get(int id) {
        return ResponseEntity.ok(bookingMapper.toDto(bookingService.get(id)));
    }
}
