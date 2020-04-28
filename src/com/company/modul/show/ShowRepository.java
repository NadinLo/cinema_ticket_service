package com.company.modul.show;

import com.company.modul.DBConnector;
import com.company.modul.IRepository;
import com.company.modul.film.Film;
import com.company.modul.film.FilmRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class ShowRepository implements IRepository {

    private DBConnector dbConnector;
    private FilmRepository filmRepository = new FilmRepository();

    public ShowRepository (){
        this.dbConnector = DBConnector.getInstance();
    }

    @Override
    public ArrayList<Show> findAll() {
        ArrayList<Film> films = filmRepository.findAll();
        ArrayList<Show> shows = new ArrayList<>();
        ResultSet rs = dbConnector.fetchData("SELECT *,  hall.capacity " +
                "FROM cinema_show " +
                "Inner JOIN hall ON cinema_show.hall_id = hall.id " +
                "WHERE cinema_show.cinema_id = 1");
        if (rs == null){
            System.out.println("no show found");
            return null;
        }
        try {
            while (rs.next()){
                int showId = rs.getInt("id");
                int capacity = rs.getInt("hall.capacity");
                int hallId = rs.getInt("hall_id");
                int filmId = rs.getInt("film_id");
                Timestamp showTime = rs.getTimestamp("show_time");
                int soldTickets = rs.getInt("sold_tickets");
                //todo: Wie kann ich Logik auslagern?
                for (Film film : films) {
                    if (film.getId() == filmId) {
                        shows.add(new Show(film, showId, capacity, hallId, showTime, soldTickets));
                    }
                }
            }
        } catch (SQLException ex){
            System.out.println("couldn't fetch data");
            ex.printStackTrace();
        } finally {
            dbConnector.closeConnection();
        }

        return shows;

    }

    @Override
    public Show findOne(int id) {
        Show show = null;
        ResultSet rs = dbConnector.fetchData("SELECT *,  hall.capacity " +
                "FROM cinema_show " +
                "Inner JOIN hall ON cinema_show.hall_id = hall.id " +
                "WHERE cinema_show.id = " + id);
        if (rs == null){
            System.out.println("no show found");
            return null;
        }
        try {
            while (rs.next()) {
                int hallId = rs.getInt("hall_id");
                int capacity = rs.getInt("hall.capacity");
                Timestamp showTime = rs.getTimestamp("show_time");
                int soldTickets = rs.getInt("sold_tickets");
                Film film = filmRepository.findOne(rs.getInt("film_id"));
                show = new Show(film, id, capacity, hallId, showTime, soldTickets);
            }

        } catch (SQLException ex){
            System.out.println("couldn't fetch data");
            ex.printStackTrace();
        } finally {
            dbConnector.closeConnection();
        }

        return show;
    }

    @Override
    public boolean create(Object entity) {
        return false;
    }

    public ArrayList<Show> findALL (int filmId){
        //todo: Wie kann ich Logik auslagern?
        Film film = filmRepository.findOne(filmId);
        ArrayList<Show> shows = new ArrayList<>();
        ResultSet rs = dbConnector.fetchData("SELECT *, hall.capacity " +
                "FROM cinema_show " +
                "Inner JOIN hall ON cinema_show.hall_id = hall.id " +
                "WHERE cinema_show.cinema_id = 1 AND film_id = " + filmId);
        if (rs == null){
            System.out.println("no show found");
            return null;
        }
        try {
            while (rs.next()) {
                int showId = rs.getInt("id");
                int capacity = rs.getInt("hall.capacity");
                int hallId = rs.getInt("hall_id");
                Timestamp showTime = rs.getTimestamp("show_time");
                int soldTickets = rs.getInt("sold_tickets");
                shows.add(new Show(film, showId, capacity, hallId, showTime, soldTickets));
            }

        } catch (SQLException ex){
            System.out.println("couldn't fetch data");
            ex.printStackTrace();
        } finally {
            dbConnector.closeConnection();
        }

        return shows;
    }

}
