package com.company.modul.film;

import com.company.modul.DBConnector;
import com.company.modul.IRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

public class FilmRepository implements IRepository {
    private DBConnector dbConnector;

    public FilmRepository (){
        this.dbConnector = DBConnector.getInstance();
    }

    @Override
    public ArrayList<Film> findAll() {
        ArrayList<Film> films = new ArrayList<>();
        ResultSet rs = dbConnector.fetchData("SELECT film.id, film.name, director.name, genre.genre_name, film.duration " +
                "FROM `film` " +
                "INNER JOIN director ON film.director_id = director.id " +
                "INNER JOIN genre ON film.genre_id = genre.id");
        if (rs == null){
            System.out.println("No films found");
            return null;
        }
        try {
            while (rs.next()) {
                int id = rs.getInt("film.id");
                String name = rs.getString("film.name");
                String director = rs.getString("director.name");
                String genre = rs.getString("genre.genre_name");
                Time duration = rs.getTime("film.duration");
                films.add(new Film(id, name, director, duration, genre));
            }
        }catch (SQLException ex){
                System.out.println("couldn't fetch data");
                ex.printStackTrace();
            } finally {
            dbConnector.closeConnection();
        }
        return films;
    }

    @Override
    public Film findOne(int id) {
        Film film = null;
        ResultSet rs = dbConnector.fetchData("SELECT film.id, film.name, director.name, genre.genre_name, film.duration " +
                "FROM `film` " +
                "INNER JOIN director ON film.director_id = director.id " +
                "INNER JOIN genre ON film.genre_id = genre.id " +
                "WHERE film.id = " + id);
        if (rs == null){
            System.out.println("no film found");
            return null;
        }
        try {
            if (rs.next()){
                String name = rs.getString("film.name");
                String director = rs.getString("director.name");
                String genre = rs.getString("genre.genre_name");
                Time duration = rs.getTime("film.duration");
                film = new Film(id, name, director, duration, genre);
            }
        } catch (SQLException ex){
            System.out.println("couldn't fetch data.");
            ex.printStackTrace();
        } finally {
            dbConnector.closeConnection();
        }
        return film;
    }

    @Override
    public boolean create(Object entity) {
        return false;
    }
}
