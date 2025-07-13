package com.yk.att.mtbs.movies.mappers;

import com.yk.att.mtbs.movies.dto.ShowtimeDto;
import com.yk.att.mtbs.movies.model.Showtime;
import org.springframework.stereotype.Service;

@Service
@org.mapstruct.Mapper(componentModel = "spring")
public interface ShowtimeMapper extends Mapper<Showtime, ShowtimeDto> {}
