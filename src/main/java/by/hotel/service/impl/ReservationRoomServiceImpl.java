package by.hotel.service.impl;

import by.hotel.bean.ReservationRoom;
import by.hotel.dao.daoimpl.ReservationRoomDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.CrudService;
import by.hotel.service.exception.ServiceException;

import java.util.List;

/**
 * Created by 1 on 07.04.2017.
 */
public class ReservationRoomImpl implements CrudService<ReservationRoom> {
    ReservationRoomDaoImpl reservationRoomDao = new ReservationRoomDaoImpl();

    public List<ReservationRoom> getAllEntities() throws ServiceException {
        try {
            return reservationRoomDao.getReservationRooms();
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public void addEntity(ReservationRoom entity) throws ServiceException {
        try {
            reservationRoomDao.addReservationRoom(entity);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public void removeEntity(ReservationRoom entity) throws ServiceException {
        try {
            reservationRoomDao.removeReservationRoom(entity);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public void updateEntity(ReservationRoom entity) throws ServiceException {
        try {
            reservationRoomDao.updateReservationRoom(entity);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }
}
