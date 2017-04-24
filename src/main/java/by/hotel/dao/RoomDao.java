package by.hotel.dao;

import by.hotel.bean.Discount;
import by.hotel.bean.Room;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.util.List;

public interface RoomDao {
    List<String> getRoomHeaders(Connection connection) throws DAOException;
    List<Room> getRooms(Connection connection) throws DAOException;
    void addRoom(Room room, Connection connection) throws DAOException;
    void removeRoom(Room room, Connection connection) throws DAOException;
    void updateRoom(Room room, Connection connection) throws DAOException;
    Room getLastInsertedRoom(Connection connection) throws DAOException;

}
