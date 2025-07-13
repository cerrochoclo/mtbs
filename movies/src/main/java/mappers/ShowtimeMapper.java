package mappers;

import dto.ShowtimeDto;
import model.Showtime;

@org.mapstruct.Mapper(componentModel = "spring")
public interface ShowtimeMapper extends Mapper<Showtime, ShowtimeDto> {}
