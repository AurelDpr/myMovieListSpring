package com.example.myMovieListSpring.entities;

import javax.persistence.*;

@Entity
@Table(name = "movie")
public class Movies {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Long userId;
    private String title;
    private String posterPath;

    public Movies() {
    }

    public Movies(Movies movie) {
        this.userId = movie.userId;
        this.title = movie.title;
        this.posterPath = movie.posterPath;
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
}
