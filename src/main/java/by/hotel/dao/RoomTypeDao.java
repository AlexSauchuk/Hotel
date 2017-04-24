package by.hotel.dao;

import by.hotel.bean.Discount;
import by.hotel.bean.RoomType;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.util.List;

public interface RoomTypeDao {
    List<String> getRoomTypeHeaders(Connection connection) throws DAOException;
    List<RoomType> getRoomTypes(Connection connection) throws DAOException;
    void addRoomType(RoomType roomType, Connection connection) throws DAOException;
    void removeRoomType(RoomType roomType, Connection connection) throws DAOException;
    void updateRoomType(RoomType roomType, Connection connection) throws DAOException;
    RoomType getLastInsertedRoomType(Connection connection) throws DAOException;

}
