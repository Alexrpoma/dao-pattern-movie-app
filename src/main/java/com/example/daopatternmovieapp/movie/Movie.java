package com.example.daopatternmovieapp.movie;

import com.example.daopatternmovieapp.actor.Actor;

import java.time.LocalDate;
import java.util.List;

public record Movie(
  Integer id,
  String name,
  List<Actor> actors,
  LocalDate releaseDate
) {
}
