package by.hotel.dao;

import by.hotel.bean.ReservationRoom;
import by.hotel.dao.exception.DAOException;

import java.util.List;

public interface ReservationRoomDao {
    List<Integer> getId() throws DAOException;
    List<ReservationRoom> getReservationRooms() throws DAOException;

    void addReservationRoom(ReservationRoom reservationRoom) throws DAOException;

    void removeReservationRoom(ReservationRoom reservationRoom) throws DAOException;

    void updateReservationRoom(ReservationRoom reservationRoom) throws DAOException;

}
