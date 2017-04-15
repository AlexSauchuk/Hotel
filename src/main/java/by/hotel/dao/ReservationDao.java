package by.hotel.dao;

import by.hotel.bean.Reservation;
import by.hotel.dao.exception.DAOException;

import java.util.List;

public interface ReservationDao {
    List<Integer> getId() throws DAOException;
    List<Reservation> getAllReservations() throws DAOException;

    void addReservation(Reservation room) throws DAOException;

    void removeReservation(Reservation room) throws DAOException;

    void updateReservation(Reservation room) throws DAOException;
}
