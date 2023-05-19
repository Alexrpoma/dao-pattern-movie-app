package com.example.daopatternmovieapp.movie;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {

  private final MovieService movieService;

  public MovieController(MovieService movieService) {
    this.movieService = movieService;
  }

  @GetMapping
  public ResponseEntity<List<Movie>> listMovies() {
    return ResponseEntity.ok(movieService.getMovies());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Movie> getMovie(@PathVariable("id") int id) {
    return ResponseEntity.ok(movieService.getMovie(id));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void addMovie(@RequestBody Movie movie) {
    movieService.addNewMovie(movie);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteMovie(@PathVariable("id") Integer id) {
    movieService.deleteMovie(id);
    return ResponseEntity.accepted().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Movie> updateMovie(@PathVariable("id") Integer id, @RequestBody Movie movie) {
    return ResponseEntity.ok(movieService.updateMovie(movie, id));
  }

}
