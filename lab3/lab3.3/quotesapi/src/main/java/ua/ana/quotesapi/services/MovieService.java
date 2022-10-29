package ua.ana.quotesapi.services;


import ua.ana.quotesapi.entities.*;
import ua.ana.quotesapi.repositories.*;
import ua.ana.quotesapi.exeptionhandle.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class MovieService {

    @Autowired
    private MoviesRepository repository;


    //POST
    public Movie saveMovie(Movie movie) {
        return repository.save(movie);
    }


    public List<Movie> saveMovies(List<Movie> movies) {
        return repository.saveAll(movies);
    }




    //GET

    public List<Movie> getMovies() {
        return repository.findAll();
    }

    public Movie getMovieById(int id) throws ResourceNotFoundException{
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Movie Id not found, unable to get Movie!"));
    }


    public Movie getMovieByTitle(String title) throws ResourceNotFoundException{
        if (repository.findByTitle(title) != null){
             return repository.findByTitle(title);   
        }
        else{
            throw new ResourceNotFoundException("Movie Title not found, unable to get Movie!");
        }
    }


    public Object[] getMovieQuotes(int id) throws ResourceNotFoundException{
        Movie existingMovie = (repository.findById(id)).orElseThrow(() -> new ResourceNotFoundException("Movie Id not found, unable to get Quotes!"));
        return existingMovie.getQuotes().toArray();
    }



    //PUT

    public Movie updateMovie(Movie movie, int id) throws ResourceNotFoundException{

            Movie existingMovie = (repository.findById(id)).orElseThrow(() -> new ResourceNotFoundException("Movie Id not found, unable update Movie!"));
            existingMovie.setTitle(movie.getTitle());
            existingMovie.setYear(movie.getYear());
            existingMovie.setGenre(movie.getGenre());
            return repository.save(existingMovie);                   
    }

    public Movie addQuoteToMovie(Quote quote, int id) throws ResourceNotFoundException{
        
        Movie existingMovie = (repository.findById(id)).orElseThrow(() -> new ResourceNotFoundException("Movie Id not found, unable to add Quote!")); 
        existingMovie.addQuote(quote);
        return repository.save(existingMovie); 
    

    }



    public String deleteMovie(int id) {

            repository.deleteById(id);        
            return "Movie: "+ id + " has been removed" ;
       
    }

   
}
