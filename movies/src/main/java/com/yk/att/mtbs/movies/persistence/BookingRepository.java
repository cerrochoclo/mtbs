package com.yk.att.mtbs.movies.persistence;

import com.yk.att.mtbs.movies.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
