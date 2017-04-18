package by.hotel.dao;

import by.hotel.bean.Reservation;
import by.hotel.dao.exception.DAOException;

import java.util.List;

public interface ReservationDao {
    List<String> getReservationHeaders() throws DAOException;
    List<Reservation> getAllReservations() throws DAOException;
    void addReservation(Reservation reservation) throws DAOException;
    void removeReservation(Reservation reservation) throws DAOException;
    void updateReservation(Reservation reservation) throws DAOException;
}
