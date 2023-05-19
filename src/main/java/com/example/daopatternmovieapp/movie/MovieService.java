package com.example.daopatternmovieapp.movie;

import java.util.List;
import java.util.Optional;

public class MovieService {

  private final MovieDAO movieDAO;

  public MovieService(MovieDAO movieDAO) {
    this.movieDAO = movieDAO;
  }

  public List<Movie> getMovies() {
    return movieDAO.selectMovies();
  }

  public void addNewMovie(Movie movie) {
    // TODO: check if movie exists
    int result = movieDAO.insertMovie(movie);
    if (result != 1) {
      throw new IllegalStateException("oops something went wrong");
    }
  }

  public void deleteMovie(Integer id) {
    Optional<Movie> movie = movieDAO.selectMovieById(id);
    movie.ifPresentOrElse(mv -> {
      int result = movieDAO.deleteMovie(id);
      if (result != 1) {
        throw new IllegalStateException("oops could not delete movie");
      }
    }, () -> {
        throw new IllegalStateException("oops could not delete movie");
    });
  }

  public Movie getMovie(int id) {
    return movieDAO.selectMovieById(id).orElseThrow(
      () -> new IllegalStateException("not found")
    );
  }
}
