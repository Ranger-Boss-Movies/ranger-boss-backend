package com.example.rangerbossbackend.controllers;

import com.example.rangerbossbackend.data.*;
import lombok.AllArgsConstructor;
import misc.FieldHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/movies", produces = "application/json")
@CrossOrigin
public class MoviesController {
    private MoviesRepository moviesRepository;
    private DirectorsRepository directorsRepository;
    private GenresRepository genresRepository;
    private ActorsRepository actorsRepository;

    @GetMapping("")
    public List<Movie> getAll() {
        return moviesRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Movie> fetchMovieById(@PathVariable long id) {
        Optional<Movie> optionalMovie = moviesRepository.findById(id);
        if (optionalMovie.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie id " + id + " not found");
        }
        return optionalMovie;
    }

    @PostMapping("")
    private void addNewMovie(@RequestBody Movie newMovie) {
        if (newMovie.getTitle() == null || newMovie.getTitle().length() < 1) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Title cannot be blank!");
        }
        System.out.println(newMovie);
        for(Genre genre : newMovie.getGenres()) {
            // find the genre id and set it
            Genre ourGenre = genresRepository.findByName(genre.getName());
            genre.setId(ourGenre.getId());
        }

        moviesRepository.save(newMovie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovieById(@PathVariable long id) {
        Optional<Movie> optionalUser = moviesRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie " + id + " not found");
        }
        moviesRepository.deleteById(id);
    }
    @PutMapping("/{id}")
    public void updateMovie(@RequestBody Movie updatedMovie, @PathVariable long id) {
        Optional<Movie> optionalMovie = moviesRepository.findById(id);
        if (optionalMovie.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie " + id + " not found");
        }
        Movie originalMovie = optionalMovie.get();
        updatedMovie.setId(id);
        BeanUtils.copyProperties(updatedMovie, originalMovie, FieldHelper.getNullPropertyNames(updatedMovie));
        moviesRepository.save(originalMovie);
    }

}