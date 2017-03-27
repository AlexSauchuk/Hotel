package by.hotel.dao;

import by.hotel.bean.Room;
import by.hotel.dao.exception.DAOException;

import java.util.List;

/**
 * Created by user1 on 16.03.2017.
 */
public interface RoomDao {
    List<Room> getRooms() throws DAOException;
    void addRoom(Room room) throws DAOException;
    void removeRoom(Room room) throws DAOException;
    void updateRoom(Room room) throws DAOException;
}
