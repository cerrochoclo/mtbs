package services;

import dto.BookingDto;
import model.Booking;
import org.springframework.http.ResponseEntity;

public interface BookingService {

    BookingDto add(Booking model);

    Booking get(int id);
}
