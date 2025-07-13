package services;

import model.Showtime;

import java.util.List;
import java.util.Optional;

public interface ShowtimeService {

    Showtime get(int id);

    Showtime add(Showtime showtime);

    List<Showtime> fetchByMovieByTheatre(int movieId, int theatreId);
}
