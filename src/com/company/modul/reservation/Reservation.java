package com.company.modul.reservation;

import com.company.modul.show.Show;
import com.company.modul.user.User;

public class Reservation {
    private int id;
    private User user;
    private Show show;
    private int amountTickets;

    public Reservation(User user, Show show, int amountTickets) {
        this.user = user;
        this.show = show;
        this.amountTickets = amountTickets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public Show getShow() {
        return show;
    }

    public int getAmountTickets() {
        return amountTickets;
    }

}
