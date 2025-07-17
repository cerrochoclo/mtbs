package com.yk.att.mtbs.movies.services;

import com.yk.att.mtbs.movies.model.Booking;
import com.yk.att.mtbs.movies.model.Showtime;
import com.yk.att.mtbs.movies.persistence.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final ShowtimeService showtimeService;
    private final JpaHelper<Booking> jpaHelper;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository, ShowtimeService showtimeService, JpaHelper<Booking> jpaHelper) {
        this.bookingRepository = bookingRepository;
        this.showtimeService = showtimeService;
        this.jpaHelper = jpaHelper;
    }

    @Override
    public Booking add(Booking booking) throws ValidationException {
        validateSeatNumber(booking);
        return bookingRepository.save(booking);
    }

    private void validateSeatNumber(Booking booking) throws ValidationException {
        Showtime currentShowtime = showtimeService.get(booking.getShowtimeId());
        if(booking.getSeatNumber() > currentShowtime.getMaxSeats()) {
            throw new ValidationException("Seat number is Invalid");
        }
    }

    @Override
    public Booking get(int id) {
        return jpaHelper.getNonDeleted(id, bookingRepository);
    }

    @Override
    public List<Booking> getAll() {
        return jpaHelper.findAllNonDeleted(bookingRepository);
    }
}
