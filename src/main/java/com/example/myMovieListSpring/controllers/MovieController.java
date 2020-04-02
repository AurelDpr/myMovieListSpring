package com.example.myMovieListSpring.controllers;

import com.example.myMovieListSpring.entities.Movies;
import com.example.myMovieListSpring.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/movie")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @CrossOrigin
    @GetMapping(path="/read")
    public Iterable<Movies> getAllMovies() {
        return movieRepository.findAll();
    }

    @CrossOrigin
    @GetMapping(path="/get")
    public Iterable<Movies> getMoviesByUserId(@RequestParam Long userId) {
        return movieRepository.findByUserId(userId);
    }

    @CrossOrigin
    @PostMapping(path="/create")
    public Movies addNewMovie (@RequestBody Movies movie) {
        Movies movieFromDb = new Movies(movie);
        movieRepository.save(movieFromDb);
        return movieFromDb;
    }

    @CrossOrigin
    @DeleteMapping(path="/delete")
    public @ResponseBody Movies deleteMovie (@RequestParam Long movieId) {
        Movies movieFromDb = movieRepository.findById(movieId).get();
        movieRepository.deleteById(movieId);
        return movieFromDb;
    }

    @CrossOrigin
    @PatchMapping(path="/update")
    public @ResponseBody String updateMovie (@RequestParam Movies movie) {
        Movies movieFromDb = movieRepository.findById(movie.getId()).get();
        movieFromDb.setPosterPath(movie.getPosterPath());
        movieFromDb.setTitle(movie.getTitle());
        movieFromDb.setUserId(movie.getUserId());
        movieRepository.save(movieFromDb);
        return "update";
    }
}
