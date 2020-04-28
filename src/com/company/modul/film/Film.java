package com.company.modul.film;

import java.sql.Time;

public class Film {
    private int id;
    private String name;
    private String director;
    private Time duration;
    private String genre;

    public Film(int id, String name, String director, Time duration, String genre) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.duration = duration;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }

    public Time getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }

}
