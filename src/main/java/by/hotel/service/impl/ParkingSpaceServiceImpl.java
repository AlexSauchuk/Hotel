package by.hotel.service.impl;

import by.hotel.bean.ParkingSpace;
import by.hotel.builder.ParkingSpaceBuilder;
import by.hotel.dao.daoimpl.ParkingSpaceDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.CrudServiceExtended;
import by.hotel.service.AbstractService;
import by.hotel.service.exception.ServiceException;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class ParkingSpaceServiceImpl extends AbstractService implements CrudServiceExtended<ParkingSpace> {
    private ParkingSpaceDaoImpl parkingSpaceDao = new ParkingSpaceDaoImpl();

    public List<String> getAllHeaders() throws ServiceException {
        try {
            return parkingSpaceDao.getParkingSpaceHeaders();
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public List<ParkingSpace> getAllEntities() throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            return parkingSpaceDao.getParkingSpaces(connection);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public void addEntity(ParkingSpace entity) throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            parkingSpaceDao.addParkingSpace(entity,connection);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public void removeEntity(ParkingSpace parkingSpace) throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            parkingSpaceDao.removeParkingSpace(parkingSpace,connection);
        }catch (DAOException e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
    }

    public void updateEntity(ParkingSpace entity) throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            parkingSpaceDao.updateParkingSpace(entity,connection);
        }catch (DAOException e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
    }

    public ParkingSpace buildEntity(Map<String, String[]> params) throws ServiceException {
        return new ParkingSpaceBuilder().id(Integer.parseInt(params.get("id")[0]))
                .level(Integer.parseInt(params.get("level")[0]))
                .reserved(Byte.parseByte(params.get("isReserved")[0]))
                .build();
    }
}
