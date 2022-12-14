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

        Director ourDirector = directorsRepository.findByName(newMovie.getDirector().getName());
        if(ourDirector == null) {
            Director newDirector = new Director();
            newDirector.setName(ourDirector.getName());
            directorsRepository.save(newDirector);
            ourDirector.setId(newDirector.getId());
        }
        newMovie.setDirector(ourDirector);

        for(Genre genre : newMovie.getGenres()) {
            // find the genre id and set it
            Genre ourGenre = genresRepository.findByName(genre.getName());
            if(ourGenre == null) {
                Genre newGenre = new Genre();
                newGenre.setName(genre.getName());
                genresRepository.save(newGenre);
                genre.setId(newGenre.getId());
            } else {
                genre.setId(ourGenre.getId());
            }
        }

        for(Actor actor : newMovie.getActors()) {
            // find the actor id and set it
            Actor ourActor = actorsRepository.findByName(actor.getName());
            if(ourActor == null) {
                Actor newActor = new Actor();
                newActor.setName(actor.getName());
                actorsRepository.save(newActor);
                actor.setId(newActor.getId());
            } else {
                actor.setId(ourActor.getId());
            }
        }

        System.out.println(newMovie);

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