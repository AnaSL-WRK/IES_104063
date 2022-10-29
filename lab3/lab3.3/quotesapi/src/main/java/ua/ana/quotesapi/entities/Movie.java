package ua.ana.quotesapi.entities;



import java.util.List;

//import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "movie")

public class Movie {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "type", nullable = false)
    private  String type;

    @Column(name = "title", nullable = false)
    private  String title;


    @Column(name = "year", nullable = false)
    private  long year;

	@Column(name = "genre", nullable = false)
    private  String genre;
    


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "quotes", nullable = false, columnDefinition = "")
    private List<Quote> quotes;



	
	

	public Movie(){

	}


	public Movie(String type, String title, Long year, String genre) {

		this.type = type;
        this.title = title;
        this.year = year;
		this.genre = genre;
	}


	public int getId() {
        return id;
    }


	public String getType() {
		return type;
	}

	public String getTitle() {
		return title;
	}

	public Long getYear() {
		return year;
	}

	public String getGenre() {
		return genre;
	}


//QUOTES

	public List<Quote> getQuotes(){
        return quotes;
    }




	public void setQuotes(List<Quote> quotes) {
		this.quotes = quotes;

	}
	
	public void addQuote(Quote content){
        quotes.add(content);
    }
///


	public void setType(String type) {
		this.type = type;
	}
	
	
    public void setTitle(String title) {
		this.title = title;
	}
	
    public void setYear(Long year) {
		this.year = year;
	}
	
    public void setGenre(String genre) {
		this.genre = genre;
	}


	





	@Override
	public String toString() {
	
		String output = "[id: " + id + ", type: " + type +", title: " + title + ", year: " + year + ", genre: " + genre + "]";
	   
	
		return output;
	}
	
    

}
   


   

