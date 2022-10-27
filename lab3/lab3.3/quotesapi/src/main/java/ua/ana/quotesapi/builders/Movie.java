package ua.ana.quotesapi.builders;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SHOWS_TBL")

public class Movie {

    @Id
    @GeneratedValue

   private long id;
   private String name;
   private Long year;
   private String genre;
   private String quote;
   
    public Movie orElse(Object object) {
	return null;
}
   

}