package com.company.modul.show;

import com.company.modul.film.Film;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class Show implements Comparable{
    private Film film;
    private int id;
    private int hallID;
    private Timestamp showTime;
    private int soldTickets;
    private Date date;
    private Time time;
    private int freeSeats;

    public Show(Film film, int id, int capacity, int hallID, Timestamp showTime, int soldTickets) {
        this.id = id;
        this.hallID = hallID;
        this.showTime = showTime;
        this.soldTickets = soldTickets;
        this.film = film;
        this.freeSeats = capacity - this.soldTickets;
        this.date = new Date(this.showTime.getTime());
        this.time = new Time(this.showTime.getTime());
    }

    public Film getFilm() {
        return film;
    }

    public int getId() {
        return id;
    }

    public int getHallID() {
        return hallID;
    }

    public Timestamp getShowTime() {
        return showTime;
    }

    public int getSoldTickets() {
        return soldTickets;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public int getFreeSeats() {
        return freeSeats;
    }

    @Override
    public int compareTo(Object o) {
        Show other = (Show) o;
        return this.film.getName().compareTo(other.film.getName());
    }
}
