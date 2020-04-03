package com.example.myMovieListSpring.entities;

import javax.persistence.*;

@Entity
@Table(name = "movie")
public class Movies {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Long userId;
    private Long movieId;
    private String title;
    private String type;
    private String posterPath;

    public Movies() {
    }

    public Movies(Movies movie) {
        this.movieId = movie.movieId;
        this.userId = movie.userId;
        this.title = movie.title;
        this.posterPath = movie.posterPath;
        this.type = movie.type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
