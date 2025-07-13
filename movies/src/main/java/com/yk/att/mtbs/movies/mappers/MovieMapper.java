package com.yk.att.mtbs.movies.mappers;

import com.yk.att.mtbs.movies.dto.MovieDto;
import com.yk.att.mtbs.movies.model.Movie;
import org.springframework.stereotype.Service;

@Service
@org.mapstruct.Mapper(componentModel = "spring")
public interface MovieMapper extends Mapper<Movie, MovieDto> {}