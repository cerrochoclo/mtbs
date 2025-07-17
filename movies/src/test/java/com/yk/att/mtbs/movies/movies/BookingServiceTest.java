package com.yk.att.mtbs.movies.movies;

import com.yk.att.mtbs.movies.model.Booking;
import com.yk.att.mtbs.movies.model.Showtime;
import com.yk.att.mtbs.movies.persistence.BookingRepository;
import com.yk.att.mtbs.movies.services.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.OffsetDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {

    @InjectMocks
    private BookingServiceImpl bookingService;

    @Mock
    private ShowtimeServiceImpl showtimeService;

    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private JpaHelper<Booking> jpaHelper;

    @Test
    void testAdd_success() {
        Booking bookingToAdd = new Booking(null,2,2,"avi.cohen",110.0F,false);
        when(bookingRepository.save(bookingToAdd)).thenReturn(new Booking(1,2, 2,
                "avi.cohen",110.0F,false));
        when(showtimeService.get(2)).thenReturn(new Showtime(1,2,1, OffsetDateTime.now(),OffsetDateTime.now(),10000,false));
        Booking addedBooking = null;
        try {
            addedBooking = bookingService.add(bookingToAdd);
        } catch (ValidationException e) {
            Assertions.assertNull(e);
        }

        Assertions.assertEquals(1,addedBooking.getId());
        Assertions.assertEquals(2,addedBooking.getShowtimeId());
        Assertions.assertEquals(2,addedBooking.getSeatNumber());
        Assertions.assertEquals("avi.cohen",addedBooking.getUserName());
        Assertions.assertEquals(110.0F,addedBooking.getPrice());
        Assertions.assertFalse(addedBooking.getIsDeleted());
    }



}
