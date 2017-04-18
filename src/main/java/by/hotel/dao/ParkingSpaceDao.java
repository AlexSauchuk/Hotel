package by.hotel.dao;

import by.hotel.bean.ParkingSpace;
import by.hotel.dao.exception.DAOException;

import java.util.List;

public interface ParkingSpaceDao {
    List<Integer> getId() throws DAOException;
    List<ParkingSpace> getParkingSpaces() throws DAOException;

    void addParkingSpace(ParkingSpace parkingSpace) throws DAOException;

    void removeParkingSpace(ParkingSpace parkingSpace) throws DAOException;

    void updateParkingSpace(ParkingSpace parkingSpace) throws DAOException;

    ParkingSpace getParkingSpace(Integer id) throws DAOException;
}
