package com.company.modul.reservation;

import com.company.modul.DBConnector;
import com.company.modul.IRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ReservationRepository implements IRepository {
    DBConnector dbConnector;

    public ReservationRepository() {
        this.dbConnector = DBConnector.getInstance();
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Object findOne(int id) {
        return null;
    }

    @Override
    public boolean create(Object entity) {
        Reservation reservation = (Reservation) entity;
        if (reservation.getAmountTickets() <= reservation.getShow().getFreeSeats()) {
            if (dbConnector.insert("INSERT INTO `accounting_process` (`id`, `guest_id`, `show_id`, `amount_tickets`) " +
                    "VALUES (null, " + reservation.getUser().getId() + ", " + reservation.getShow().getId() + " ," +
                    +reservation.getAmountTickets() + ")")) {
                System.out.println("reservation done");
                //following sql is not perfect. But LAST_INSET_ID() is connection specific. Since connection after the last
                //insert was closed result would be always 0
                ResultSet rs = dbConnector.fetchData("SELECT MAX(id) FROM accounting_process");
                try {
                    if (rs.next()) {
                        int id = rs.getInt("MAX(id)");
                        reservation.setId(id);
                    }
                } catch (SQLException ex) {
                    System.out.println("could't get LAST_INSERT_ID()");
                    ex.printStackTrace();
                } finally {
                    dbConnector.closeConnection();
                }
                updateData(reservation);
                return true;
            }
            else { return false; }
        } else {
            System.out.println("Not enough tickets left. reservation not possible.");
            return false;
        }
    }

    public void updateData (Reservation reservation){
        dbConnector.update("UPDATE `cinema_show` SET `sold_tickets`= sold_tickets + " + reservation.getAmountTickets() +
                " WHERE id = " + reservation.getShow().getId());
    }
}
