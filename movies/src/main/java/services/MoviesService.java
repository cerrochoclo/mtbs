package services;

import model.Movie;

public interface MoviesService {

    Movie get(int id);

    Movie add(Movie movie);

    Movie update(Movie movie);

    Movie delete(int id);


}
