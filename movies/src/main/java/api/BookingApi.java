package api;

import model.Booking;
import model.Movie;
import org.springframework.http.ResponseEntity;

public interface BookingApi {

    ResponseEntity<Movie> add(Booking booking);

    ResponseEntity<Movie> get(int id);

}
