package ua.ana.quotesapi.builders;

import ua.ana.quotesapi.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MoviesRepository repository;

    public Movie saveMovie(Movie movie) {
        return repository.save(movie);
    }

    public List<Movie> saveMovies(List<Movie> movies) {
        return repository.saveAll(movies);
    }

    public List<Movie> getMovies() {
        return repository.findAll();
    }

    public Movie getMovieById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Movie getMovieByName(String name) {
        return repository.findByName(name);
    }

    public String deleteMovie(int id) {
        repository.deleteById(id);
        return "Movie: "+ id + " has been removed" ;
    }

    public Movie updateMovie(Movie movie) {
        Movie existingMovie = repository.findById(movie.getId()).orElse(null);
        existingMovie.setName(movie.getName());
        existingMovie.setYear(movie.getYear());
        existingMovie.setGenre(movie.getGenre());
        existingMovie.setQuote(movie.getQuote());
        return repository.save(existingMovie);
    }
}
