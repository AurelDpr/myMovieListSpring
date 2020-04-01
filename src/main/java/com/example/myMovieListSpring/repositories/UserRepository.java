package com.example.myMovieListSpring.repositories;

import com.example.myMovieListSpring.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  UserRepository extends JpaRepository<Users, Long> {
    Users findByUsernameAndPassword(String username, String password);

}
