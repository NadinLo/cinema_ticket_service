package com.company.view;

import com.company.modul.reservation.Reservation;

public class PrintReservation {
    public void printReservation (Reservation reservation){
        System.out.println("YOUR RESERVATION AS FOLLOWS:");
        System.out.println("Reservation No.: " + reservation.getId());
        System.out.println("Show time: " + reservation.getShow().getDate().toString().substring(0, 10) + " " + reservation.getShow().getTime());
        System.out.println("Film: " + reservation.getShow().getFilm().getName());
        System.out.println("Cinema hall: " + reservation.getShow().getHallID());
        System.out.println("Tickets: " + reservation.getAmountTickets());
        System.out.println("Please pick up the tickets at our cash desk 30 minutes before the show at the latest");
    }
}
