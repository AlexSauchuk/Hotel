package by.hotel.dao;

import by.hotel.bean.Reservation;
import by.hotel.dao.exception.DAOException;

import java.util.List;

public interface ReservationDao {
    List<Reservation> getAllReservationInfo() throws DAOException;
    void addReservationInfo(Reservation reservationInfo) throws DAOException;
    void removeReservationInfo(Reservation reservationInfo) throws DAOException;
    void updateReservationInfo(Reservation reservationInfo) throws DAOException;
}
