package com.example.myMovieListSpring.controllers;

import com.example.myMovieListSpring.entities.Users;
import com.example.myMovieListSpring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @CrossOrigin
    @GetMapping(path="/read")
    public Iterable<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @CrossOrigin
    @PostMapping(path="/create") // Map ONLY POST Requests
    public Users addNewUser (@RequestBody Users user) {
        Users userFromDb = new Users(user);
        userRepository.save(userFromDb);
        return userFromDb;
    }

    @CrossOrigin
    @PostMapping(path="/login")
    public Users login(@RequestBody Users user) {
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @CrossOrigin
    @DeleteMapping(path="/delete")
    public @ResponseBody String deleteUser (@RequestParam Long userId) {
        userRepository.deleteById(userId);
        return "suppression";
    }

    @CrossOrigin
    @PatchMapping(path="/update")
    public @ResponseBody String updateUser (@RequestParam Users user) {
        Users userFromDb = userRepository.findById(user.getId()).get();
        userFromDb.setEmail(user.getEmail());
        userFromDb.setPassword(user.getPassword());
        userFromDb.setUsername(user.getUsername());
        userRepository.save(userFromDb);
        return "update";
    }
}
