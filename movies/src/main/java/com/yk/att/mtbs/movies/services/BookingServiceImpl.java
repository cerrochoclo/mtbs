package com.yk.att.mtbs.movies.services;

import com.yk.att.mtbs.movies.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yk.att.mtbs.movies.persistence.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking add(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking get(int id) {
        return bookingRepository.getReferenceById(id);
    }
}
