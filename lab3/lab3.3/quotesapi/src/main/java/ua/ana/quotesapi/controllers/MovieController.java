package ua.ana.quotesapi.controllers;

import ua.ana.quotesapi.entities.*;
import ua.ana.quotesapi.exeptionhandle.ResourceNotFoundException;
import ua.ana.quotesapi.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MovieController {

    @Autowired
    private MovieService service;


    //POST

    @PostMapping("/addMovie")
    public Movie addMovie(@RequestBody Movie movie) {
        return service.saveMovie(movie);
    }


    @PostMapping("/addMovies")
    public List<Movie> addMovies(@RequestBody List<Movie> movies) {
        return service.saveMovies(movies);
    }



    //GET


    @GetMapping("/allMovies")
    public List<Movie> findAllMovies() {
        return service.getMovies();
    }


    @GetMapping("/movie/{id}")
    public Movie findMovieById(@PathVariable int id) throws ResourceNotFoundException {
        return service.getMovieById(id);
    }

    @GetMapping("/movieByTitle/{title}")
    public Movie findMovieByTitle(@PathVariable String title) throws ResourceNotFoundException {
        return service.getMovieByTitle(title);
    }


    @GetMapping("/movieQuotes/{id}")
    public Object findMovieQuotes(@PathVariable int id) throws ResourceNotFoundException{
        return service.getMovieQuotes(id);
    }   


    //PUT


    @PutMapping("/updateMovie/{id}")
    public Movie updateMovie(@PathVariable int id, @RequestBody Movie movie) throws ResourceNotFoundException {
        return service.updateMovie(movie, id);
    }


    @PutMapping("/addQuote/{id}")
    public Movie addQuoteToMovie(@PathVariable int id, @RequestBody Quote quote) throws ResourceNotFoundException {
        return service.addQuoteToMovie(quote,id);
    }



    //DELETE


    @DeleteMapping("/delete/{id}")
    public String deleteMovie(@PathVariable int id){
        return service.deleteMovie(id);
    }
}
