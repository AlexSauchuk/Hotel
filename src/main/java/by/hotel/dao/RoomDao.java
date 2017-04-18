package by.hotel.dao;

import by.hotel.bean.Room;
import by.hotel.dao.exception.DAOException;

import java.util.List;

public interface RoomDao {
    List<Integer> getId() throws DAOException;
    List<Room> getRooms() throws DAOException;
    void addRoom(Room room) throws DAOException;
    void removeRoom(Room room) throws DAOException;
    void updateRoom(Room room) throws DAOException;
}
