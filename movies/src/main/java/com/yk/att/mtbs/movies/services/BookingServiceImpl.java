package com.yk.att.mtbs.movies.services;

import com.yk.att.mtbs.movies.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yk.att.mtbs.movies.persistence.BookingRepository;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final JpaHelper<Booking> jpaHelper;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository, JpaHelper<Booking> jpaHelper) {
        this.bookingRepository = bookingRepository;
        this.jpaHelper = jpaHelper;
    }

    @Override
    public Booking add(Booking booking) {
        return bookingRepository.save(booking);
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
