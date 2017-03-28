package by.hotel.dao;

import by.hotel.bean.ReservationInfo;
import by.hotel.dao.exception.DAOException;

import java.util.List;

public interface ReservationDao {
    List<ReservationInfo> getAllReservationInfo() throws DAOException;
    void addReservationInfo(ReservationInfo room) throws DAOException;
    void removeReservationInfo(ReservationInfo room) throws DAOException;
    void updateReservationInfo(ReservationInfo room) throws DAOException;
}
