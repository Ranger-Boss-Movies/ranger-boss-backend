package com.example.rangerbossbackend.controllers;
import com.example.rangerbossbackend.data.GenresRepository;
import com.example.rangerbossbackend.data.Genre;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/genres", produces = "application/json")
@CrossOrigin
public class GenresController {
    private final GenresRepository genresRepository;

    @GetMapping
    public List<Genre> getAll() {
        return genresRepository.findAll();
    }
//    @GetMapping ("/search")
//    private Genre getGenreByName(@RequestParam String genreName) {
//        Genre genre = genresRepository.findByName(genreName);
//    }
}
