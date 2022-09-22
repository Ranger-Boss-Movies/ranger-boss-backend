package com.example.rangerbossbackend.controllers;

import com.example.rangerbossbackend.data.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/movies", produces = "application/json")
public class MoviesController {
    private MoviesRepository moviesRepository;
    private DirectorsRepository directorsRepository;
    private GenresRepository genresRepository;
    private ActorsRepository actorsRepository;

    @GetMapping("")
    public List<Movie> getAll() {
        return moviesRepository.findAll();
    }

}
