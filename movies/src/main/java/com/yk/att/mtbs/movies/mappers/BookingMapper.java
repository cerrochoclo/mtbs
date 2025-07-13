package com.yk.att.mtbs.movies.mappers;

import com.yk.att.mtbs.movies.dto.BookingDto;
import com.yk.att.mtbs.movies.model.Booking;
import org.springframework.stereotype.Service;

@Service
@org.mapstruct.Mapper(componentModel = "spring")
public interface BookingMapper extends Mapper<Booking, BookingDto> {}
