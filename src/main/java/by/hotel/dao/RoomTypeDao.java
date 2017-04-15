package by.hotel.dao;

import by.hotel.bean.RoomType;
import by.hotel.dao.exception.DAOException;

import java.util.List;

/**
 * Created by 1 on 04.04.2017.
 */
public interface RoomTypeDao {
    List<Integer> getId() throws DAOException;
    List<RoomType> getRoomTypes() throws DAOException;

    void addRoomType(RoomType roomType) throws DAOException;

    void removeRoomType(RoomType roomType) throws DAOException;

    void updateRoomType(RoomType roomType) throws DAOException;
}
