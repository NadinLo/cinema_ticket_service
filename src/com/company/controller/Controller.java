package com.company.controller;

import com.company.modul.film.FilmRepository;
import com.company.modul.reservation.Reservation;
import com.company.modul.reservation.ReservationRepository;
import com.company.modul.show.ShowRepository;
import com.company.modul.user.User;
import com.company.modul.user.UserRepository;
import com.company.view.CutomerMenu;
import com.company.view.PrintFilm;
import com.company.view.PrintReservation;
import com.company.view.PrintShow;

public class Controller {
    public static void start(User user) {
        UserRepository userRepository = new UserRepository();
        FilmRepository filmRepository = new FilmRepository();
        PrintFilm printFilm = new PrintFilm();
        ShowRepository showRepository = new ShowRepository();
        PrintShow printShow = new PrintShow();
        CutomerMenu cutomerMenu = new CutomerMenu();
        ReservationRepository reservationRepository = new ReservationRepository();
        PrintReservation printReservation = new PrintReservation();

        if (userRepository.create(user)) {
            int choose = 0;
            while (choose != 5) {
                choose = cutomerMenu.mainMenu();
                if (choose == 1) {
                    printFilm.printAllFilms(filmRepository.findAll());
                }
                if (choose == 2) {
                    printShow.printAllShowsOrderedByDate(showRepository.findAll());
                }
                if (choose == 3) {
                    int filmId = cutomerMenu.chooseFilm();
                    printShow.printAllShowsOrderedByDate(showRepository.findALL(filmId));
                }
                if (choose == 4) {
                    int showID = cutomerMenu.chooseShow();
                    int amountTickets = cutomerMenu.chooseAmountTickts();
                    Reservation reservation = new Reservation(user, showRepository.findOne(showID), amountTickets);
                    if (reservationRepository.create(reservation)) {
                        printReservation.printReservation(reservation);
                    }
                }
                if (choose == 5) {
                    cutomerMenu.farewell();
                }
            }


        }
    }
}
