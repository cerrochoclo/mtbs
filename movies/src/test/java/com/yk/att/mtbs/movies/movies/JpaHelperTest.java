package com.yk.att.mtbs.movies.movies;

import com.yk.att.mtbs.movies.model.Booking;
import com.yk.att.mtbs.movies.persistence.BookingRepository;
import com.yk.att.mtbs.movies.services.JpaHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JpaHelperTest {

    @InjectMocks
    JpaHelper<Booking> jpaHelperBooking;

    @Mock
    BookingRepository bookingRepository;


    @Test
    void jpaHelperBooking__getNonDeleted_isNotDeleted() {
        int bookingId = 1;
        when(bookingRepository.findById(bookingId)).thenReturn(Optional.of(new Booking(1,2, 2,
                "avi.cohen",110.0F,false)));
        Booking retrievedBooking = jpaHelperBooking.getNonDeleted(bookingId, bookingRepository);
        Assertions.assertNotNull(retrievedBooking);
    }

    @Test
    void jpaHelperBooking__findAllNonDeleted_someDeleted() {
        when(bookingRepository.findAll()).thenReturn(List.of(
                new Booking(1,2, 2,"avi.cohen",110.0F,true),
                new Booking(2,2, 4,"avi.cohen",150.0F,true),
                new Booking(3,2, 4,"moshe.cohen",120.0F,false)));
        List<Booking> retrievedBooking = jpaHelperBooking.findAllNonDeleted(bookingRepository);
        Assertions.assertEquals(1, retrievedBooking.size());
    }

    @Test
    void jpaHelperBooking__getNonDeleted_allDeleted() {
        when(bookingRepository.findAll()).thenReturn(List.of(
                new Booking(1,2, 2,"avi.cohen",110.0F,true),
                new Booking(2,2, 4,"avi.cohen",150.0F,true),
                new Booking(3,2, 4,"moshe.cohen",120.0F,true)));
        List<Booking> retrievedBooking = jpaHelperBooking.findAllNonDeleted(bookingRepository);
        Assertions.assertEquals(0, retrievedBooking.size());

    }

    @Test
    void jpaHelperBooking__getNonDeleted_noDeleted() {
        when(bookingRepository.findAll()).thenReturn(List.of(
                new Booking(1,2, 2,"avi.cohen",110.0F,false),
                new Booking(2,2, 4,"avi.cohen",150.0F,false),
                new Booking(3,2, 4,"moshe.cohen",120.0F,false)));
        List<Booking> retrievedBooking = jpaHelperBooking.findAllNonDeleted(bookingRepository);
        Assertions.assertEquals(3, retrievedBooking.size());

    }


}
