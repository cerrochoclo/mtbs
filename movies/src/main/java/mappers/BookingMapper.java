package mappers;

import dto.BookingDto;
import model.Booking;

@org.mapstruct.Mapper(componentModel = "spring")
public interface BookingMapper extends Mapper<Booking, BookingDto> {}
