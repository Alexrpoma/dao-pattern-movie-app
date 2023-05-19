package com.example.daopatternmovieapp.movie;

import java.util.List;
import java.util.Optional;

public interface MovieDAO {
  List<Movie> selectMovies();
  int insertMovie(Movie movie);
  int deleteMovie(int id);
  Optional<Movie> selectMovieById(int id);
  Optional<Movie> updateMovie(Movie movie, int id); // TODO: Update
}
