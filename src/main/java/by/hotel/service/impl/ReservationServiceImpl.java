package by.hotel.service.impl;

import by.hotel.bean.Reservation;
import by.hotel.dao.daoimpl.ReservationDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.CrudService;
import by.hotel.service.exception.ServiceException;

import java.util.List;

public class ReservationServiceImpl implements CrudService<Reservation>{
    private ReservationDaoImpl reservationDao = new ReservationDaoImpl();

    public List<Reservation> getAllEntities() throws ServiceException {
        try {
			return reservationDao.getAllReservationInfo();
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public void addEntity(Reservation entity) throws ServiceException {
        try {
            reservationDao.updateReservationInfo(entity);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public void removeEntity(Reservation entity) throws ServiceException {
        try {
            reservationDao.removeReservationInfo(entity);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public void updateEntity(Reservation entity) throws ServiceException {
        try {
            reservationDao.updateReservationInfo(entity);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }
}
