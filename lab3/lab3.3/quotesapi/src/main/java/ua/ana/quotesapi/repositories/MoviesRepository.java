package ua.ana.quotesapi.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.ana.quotesapi.entities.*;



@Repository
public interface MoviesRepository extends JpaRepository<Movie, Integer>{

    Movie findByTitle(String title);
    Movie findById(Long id);
}
