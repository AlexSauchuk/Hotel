package by.hotel.service.impl;

import by.hotel.bean.DiscountType;
import by.hotel.bean.ParkingSpace;
import by.hotel.dao.daoimpl.DiscountTypeDaoImpl;
import by.hotel.dao.daoimpl.ParkingSpaceDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.CrudService;
import by.hotel.service.exception.ServiceException;

import java.util.List;

/**
 * Created by 1 on 07.04.2017.
 */
public class ParkingSpaceImpl implements CrudService<ParkingSpace> {
    private ParkingSpaceDaoImpl parkingSpaceDao = new ParkingSpaceDaoImpl();

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

    public void removeEntity(ParkingSpace entity) throws ServiceException {
        try {
            parkingSpaceDao.removeParkingSpace(entity);
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
}
