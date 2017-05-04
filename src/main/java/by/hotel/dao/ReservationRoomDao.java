package by.hotel.dao;

import by.hotel.bean.ReservationRoom;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.util.List;

public interface ReservationRoomDao {
    List<ReservationRoom> getReservationRooms(Connection connection) throws DAOException;
    void addReservationRoom(ReservationRoom reservationRoom, Connection connection) throws DAOException;
    void removeReservationRoom(ReservationRoom reservationRoom, Connection connection) throws DAOException;
    void updateReservationRoom(ReservationRoom reservationRoom, Connection connection) throws DAOException;
    ReservationRoom getLastInsertedReservationRoom(Connection connection) throws DAOException;

}
