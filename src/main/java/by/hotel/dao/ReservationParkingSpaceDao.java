package by.hotel.dao;

import by.hotel.bean.ReservationParkingSpace;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.util.List;

public interface ReservationParkingSpaceDao {
    List<ReservationParkingSpace> getReservationParkingSpaces(Connection connection) throws DAOException;
    void addReservationParkingSpace(ReservationParkingSpace reservationParkingSpace, Connection connection) throws DAOException;
    void removeReservationParkingSpace(ReservationParkingSpace reservationParkingSpace, Connection connection) throws DAOException;
    void updateReservationParkingSpace(ReservationParkingSpace reservationParkingSpace, Connection connection) throws DAOException;
    ReservationParkingSpace getLastInsertedReservationParkingSpace(Connection connection) throws DAOException;

}
