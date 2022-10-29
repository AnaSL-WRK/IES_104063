package ua.ana.quotesapi.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "quote")
public class Quote {


    @Id            
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @JsonIgnore
    private long id;


    @Column(name = "quote")
    private String quote;


    @ManyToOne      
    @JoinColumn(name = "movieId")
    @JsonIgnore
    private Movie movieId;




    public Quote(){

    }


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }


    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }


    public Movie getMovieId() {
        return movieId;
    }


    public void setMovieId(Movie movieId) {
        this.movieId = movieId;
    }





@Override
   public String toString() {
       return "[id: " + id + ", Movie: "  + ", quote: " + quote + "]";
   }
}
