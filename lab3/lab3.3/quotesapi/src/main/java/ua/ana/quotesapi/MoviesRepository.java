package ua.ana.quotesapi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.ana.quotesapi.builders.*;



@Repository
public interface MoviesRepository extends JpaRepository<Movie, Integer>{

    Movie findByName(String name);
    Movie findById(Long id);
}
