package by.hotel.dao;

import by.hotel.bean.Reservation;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.util.List;

public interface ReservationDao {
    List<Reservation> getAllReservations(Connection connection) throws DAOException;

    void addReservation(Reservation reservation, Connection connection) throws DAOException;

    void removeReservation(Reservation reservation, Connection connection) throws DAOException;

    void updateReservation(Reservation reservation, Connection connection) throws DAOException;
}
