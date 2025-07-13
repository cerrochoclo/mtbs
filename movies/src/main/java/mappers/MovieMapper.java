package mappers;

import dto.MovieDto;
import model.Movie;

@org.mapstruct.Mapper(componentModel = "spring")
public interface MovieMapper extends Mapper<Movie, MovieDto> {}