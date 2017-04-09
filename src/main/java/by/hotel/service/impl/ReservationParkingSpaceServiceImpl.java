package by.hotel.service.impl;
import by.hotel.bean.ReservationParkingSpace;
import by.hotel.dao.daoimpl.ReservationParkingSpaceDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.CrudService;
import by.hotel.service.exception.ServiceException;

import java.util.List;

/**
 * Created by 1 on 07.04.2017.
 */
public class ReservationParkingSpaceImpl implements CrudService<ReservationParkingSpace> {
    ReservationParkingSpaceDaoImpl reservationParkingSpaceDao = new ReservationParkingSpaceDaoImpl();

    public List<ReservationParkingSpace> getAllEntities() throws ServiceException {
        try {
            return reservationParkingSpaceDao.getReservationParkingSpaces();
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public void addEntity(ReservationParkingSpace entity) throws ServiceException {
        try {
            reservationParkingSpaceDao.addReservationParkingSpace(entity);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public void removeEntity(ReservationParkingSpace entity) throws ServiceException {
        try {
            reservationParkingSpaceDao.removeReservationParkingSpace(entity);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public void updateEntity(ReservationParkingSpace entity) throws ServiceException {
        try {
            reservationParkingSpaceDao.updateReservationParkingSpace(entity);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }
}
