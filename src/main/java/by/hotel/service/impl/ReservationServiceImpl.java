package by.hotel.service.impl;

import by.hotel.bean.ReservationInfo;
import by.hotel.dao.daoimpl.ReservationDaoImpl;
import by.hotel.service.CrudService;
import by.hotel.service.exception.ServiceException;

import java.util.List;

/**
 * Created by user1 on 27.03.2017.
 */
public class ReservationServiceImpl implements CrudService<ReservationInfo>{
    ReservationDaoImpl reservationDao = new ReservationDaoImpl();

    public List<ReservationInfo> getAllEntities() throws ServiceException {
        return null;
    }

    public void addEntity(ReservationInfo entity) throws ServiceException {

    }

    public void removeEntity(ReservationInfo entity) throws ServiceException {

    }

    public void updateEntity(ReservationInfo entity) throws ServiceException {

    }
}
