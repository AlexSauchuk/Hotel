package by.hotel.service.impl;

import by.hotel.bean.Reservation;
import by.hotel.dao.daoimpl.ReservationDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.CrudService;
import by.hotel.service.exception.ServiceException;

import java.util.List;

/**
 * Created by user1 on 27.03.2017.
 */
public class ReservationServiceImpl implements CrudService<Reservation>{
    ReservationDaoImpl reservationDao = new ReservationDaoImpl();

    public List<Reservation> getAllEntities() throws ServiceException {
        try {
            return reservationDao.getAllReservations();
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public void addEntity(Reservation entity) throws ServiceException {
        try {
            reservationDao.addReservation(entity);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public void removeEntity(Reservation entity) throws ServiceException {
        try {
            reservationDao.removeReservation(entity);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public void updateEntity(Reservation entity) throws ServiceException {
        try {
            reservationDao.updateReservation(entity);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }
}
