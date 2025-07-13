package com.yk.att.mtbs.movies.services;

import com.yk.att.mtbs.movies.model.Booking;

import java.util.List;

public interface BookingService {

    Booking add(Booking booking);

    Booking get(int id);

    List<Booking> getAll();
}
