package by.hotel.dao;

import by.hotel.bean.ReservationInfo;
import by.hotel.dao.exception.DAOException;

import java.util.List;

public interface ReservationDao {
    List<ReservationInfo> getAllReservationInfo() throws DAOException;
    void addReservationInfo(ReservationInfo reservationInfo) throws DAOException;
    void removeReservationInfo(ReservationInfo reservationInfo) throws DAOException;
    void updateReservationInfo(ReservationInfo reservationInfo) throws DAOException;
}
