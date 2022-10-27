package ua.ana.quotesapi;

import ua.ana.quotesapi.builders.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MovieController {

    @Autowired

    private MovieService service;

    @PostMapping("/addMovie")
    public Movie addMovie(@RequestBody Movie Movie) {
        return service.saveMovie(Movie);
    }

    @PostMapping("/addMovies")
    public List<Movie> addMovies(@RequestBody List<Movie> movies) {
        return service.saveMovies(movies);
    }

    @GetMapping("/Movies")
    public List<Movie> findAllMovies() {
        return service.getMovies();
    }

    @GetMapping("/MovieById/{id}")
    public Movie findMovieById(@PathVariable int id) {
        return service.getMovieById(id);
    }

    @GetMapping("/Movies/{name}")
    public Movie findMovieByName(@PathVariable String name) {
        return service.getMovieByName(name);
    }

    @PutMapping("/update")
    public Movie updateMovie(@RequestBody Movie movie) {
        return service.updateMovie(movie);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMovie(@PathVariable int id) {
        return service.deleteMovie(id);
    }
}
