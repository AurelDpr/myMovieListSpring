package com.example.myMovieListSpring.repositories;

import com.example.myMovieListSpring.entities.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movies, Long> {
    List<Movies> findByUserId(Long userId);
}
