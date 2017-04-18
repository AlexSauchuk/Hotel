package by.hotel.service.impl;

import by.hotel.bean.ParkingSpace;
import by.hotel.builder.ParkingSpaceBuilder;
import by.hotel.dao.daoimpl.ParkingSpaceDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.CrudServiceExtended;
import by.hotel.service.exception.ServiceException;

import java.util.List;
import java.util.Map;

public class ParkingSpaceServiceImpl implements CrudServiceExtended<ParkingSpace> {
    private ParkingSpaceDaoImpl parkingSpaceDao = new ParkingSpaceDaoImpl();

    public List<String> getAllHeaders() throws ServiceException {
        try {
            return parkingSpaceDao.getParkingSpaceHeaders();
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public List<ParkingSpace> getAllEntities() throws ServiceException {
        try {
            return parkingSpaceDao.getParkingSpaces();
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public void addEntity(ParkingSpace entity) throws ServiceException {
        try {
            parkingSpaceDao.addParkingSpace(entity);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public void removeEntity(ParkingSpace parkingSpace) throws ServiceException {
        try {
            parkingSpaceDao.removeParkingSpace(parkingSpace);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public void updateEntity(ParkingSpace entity) throws ServiceException {
        try {
            parkingSpaceDao.updateParkingSpace(entity);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public ParkingSpace buildEntity(Map<String, String[]> params) throws ServiceException {
        return new ParkingSpaceBuilder().id(Integer.parseInt(params.get("id")[0]))
                .level(Integer.parseInt(params.get("level")[0]))
                .isReserved(Boolean.parseBoolean(params.get("isReserved")[0]))
                .build();
    }
}
