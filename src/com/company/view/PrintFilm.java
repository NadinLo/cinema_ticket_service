package com.company.view;

import com.company.modul.film.Film;

import java.util.ArrayList;

public class PrintFilm {

    private void printHeader (){
        System.out.println("_NO_|_FILM TITLE______________________________|_DIRECTOR________________________________|" +
                "_GENRE_______________|_DURATION____");
    }

    public void printAllFilms (ArrayList<Film> films){
        printHeader();
        for (Film film : films) {
            System.out.println(" " + (film.getId() + "  ").substring(0, 3) + "| " +
                    (film.getName() + "                                                  ").substring(0, 40) + "| " +
                    (film.getDirector() + "                                                  ").substring(0, 40) + "| " +
                    (film.getGenre() + "                              ").substring(0, 20) + "| " +
                    film.getDuration());
        }
    }

    public void printFilm (Film film){
        printHeader();
        System.out.println(" " + (film.getId() + "  ").substring(0, 3) + "| " +
                (film.getName() + "                                                  ").substring(0, 40) + "| " +
                (film.getDirector() + "                                                  ").substring(0, 40) + "| " +
                (film.getGenre() + "                              ").substring(0, 20) + "| " +
                film.getDuration());
    }
}
