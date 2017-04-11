package by.hotel.dao;

import by.hotel.bean.ReservationRoom;
import by.hotel.dao.exception.DAOException;

import java.util.List;

/**
 * Created by 1 on 06.04.2017.
 */
public interface ReservationRoomDao {
    List<ReservationRoom> getReservationRooms() throws DAOException;

    void addReservationRoom(ReservationRoom reservationRoom) throws DAOException;

    void removeReservationRoom(ReservationRoom reservationRoom) throws DAOException;

    void updateReservationRoom(ReservationRoom reservationRoom) throws DAOException;

}
