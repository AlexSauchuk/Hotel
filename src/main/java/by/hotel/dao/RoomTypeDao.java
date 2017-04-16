package by.hotel.dao;

import by.hotel.bean.RoomType;
import by.hotel.dao.exception.DAOException;

import java.util.List;

public interface RoomTypeDao {
    List<RoomType> getRoomTypes() throws DAOException;

    void addRoomType(RoomType roomType) throws DAOException;

    void removeRoomType(RoomType roomType) throws DAOException;

    void updateRoomType(RoomType roomType) throws DAOException;
}
