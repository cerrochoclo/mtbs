package com.yk.att.mtbs.movies.services;

import com.yk.att.mtbs.movies.model.Booking;

public interface BookingService {

    Booking add(Booking booking);

    Booking get(int id);
}
