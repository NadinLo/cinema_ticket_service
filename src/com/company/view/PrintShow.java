package com.company.view;

import com.company.modul.show.Show;

import java.util.ArrayList;
import java.util.Comparator;

public class PrintShow {

 /*   private void printHeaderByFilm() {
        System.out.println("_FILM_TITLE____________________|_DIRECTOR______________________|SHOW_|_SHOW_TIME_______|_HALL_|_SOLD_TICKETS__ ");
    }

  */

    private void printHeaderByDate() {
        System.out.println("_DATE______|_TIME__|SHOW_|_FILM___________________________|_DIRECTOR_______________________|_HALL|_SOLD_TICKETS_");
    }

 /*   public void printAllShowsOrderedByFilm(ArrayList<Show> shows) {
        shows.sort(Comparator.comparing(show -> show.getFilm().getName()));
        for (int i = 0; i < shows.size(); i++) {
            if (i > 0 && shows.get(i).getFilm().equals(shows.get(i-1).getFilm())){
                System.out.println("                                         ".substring(0,31)  + "| " +
                        "                                                    ".substring(0,30)  + "| " +
                        (shows.get(i).getId() + "                            ").substring(0,4)  + "| " +
                        (shows.get(i).getShowTime() + "                      ").substring(0,16) + "| " +
                        (shows.get(i).getHallID() + "                        ").substring(0, 5) + "| " +
                        shows.get(i).getSoldTickets());
            } else {
                printHeaderByFilm();
                System.out.println(" " + (shows.get(i).getFilm().getName() + "                                         ").substring(0,30)  + "| " +
                        (shows.get(i).getFilm().getDirector() + "                                                      ").substring(0,30)  + "| " +
                        (shows.get(i).getId() + "                                                                      ").substring(0,4)  + "| " +
                        (shows.get(i).getShowTime() + "                                                                ").substring(0,16) + "| " +
                        (shows.get(i).getHallID() + "                                                                  ").substring(0, 5) + "| " +
                        shows.get(i).getSoldTickets());
            }
        }
    }
  */

    public void printAllShowsOrderedByDate(ArrayList<Show> shows) {
        shows.sort(Comparator.comparing(Show::getShowTime));
        for (int i = 0; i < shows.size(); i++) {
            if (i > 0 && shows.get(i).getDate().toString().equalsIgnoreCase(shows.get(i-1).getDate().toString())){
                System.out.println("                                                                   ".substring(0,10) + " | " +
                        ("                                                                            ").substring(0,5)  + " | " +
                        (shows.get(i).getId() + "                                                     ").substring(0,3)  + " | " +
                        (shows.get(i).getFilm().getName() + "                                         ").substring(0,30) + " | " +
                        (shows.get(i).getFilm().getDirector() + "                                     ").substring(0,30) + " | " +
                        (shows.get(i).getHallID() + "                                                 ").substring(0, 3) + " | " +
                        shows.get(i).getSoldTickets());
            } else {
                printHeaderByDate();
                System.out.println((shows.get(i).getDate() + "                                        ").substring(0,10) + " | " +
                        (shows.get(i).getTime() + "                                                   ").substring(0,5)  + " | " +
                        (shows.get(i).getId() + "                                                     ").substring(0,3)  + " | " +
                        (shows.get(i).getFilm().getName() + "                                         ").substring(0,30) + " | " +
                        (shows.get(i).getFilm().getDirector() + "                                     ").substring(0,30) + " | " +
                        (shows.get(i).getHallID() + "                                                 ").substring(0, 3) + " | " +
                        shows.get(i).getSoldTickets());
            }

        }
    }
}
