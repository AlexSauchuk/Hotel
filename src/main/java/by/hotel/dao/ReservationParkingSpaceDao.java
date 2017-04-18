package by.hotel.dao;

import by.hotel.bean.ReservationParkingSpace;
import by.hotel.dao.exception.DAOException;

import java.util.List;

public interface ReservationParkingSpaceDao {
    List<ReservationParkingSpace> getReservationParkingSpaces() throws DAOException;

    void addReservationParkingSpace(ReservationParkingSpace reservationParkingSpace) throws DAOException;

    void removeReservationParkingSpace(ReservationParkingSpace reservationParkingSpace) throws DAOException;

    void updateReservationParkingSpace(ReservationParkingSpace reservationParkingSpace) throws DAOException;
}
