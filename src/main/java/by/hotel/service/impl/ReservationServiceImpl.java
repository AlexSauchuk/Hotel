package by.hotel.service.impl;

import by.hotel.bean.Discount;
import by.hotel.bean.Reservation;
import by.hotel.builder.DiscountBuilder;
import by.hotel.builder.ReservationBuilder;
import by.hotel.builder.UserBuilder;
import by.hotel.dao.daoimpl.ReservationDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.CrudService;
import by.hotel.service.exception.ServiceException;

import java.sql.Date;
import java.util.List;
import java.util.Map;

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

    public void removeEntity(Reservation reservation) throws ServiceException {
        try {
            reservationDao.removeReservation(reservation);
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

    public Reservation buildEntity(Map<String, String> params) throws ServiceException {
        return new ReservationBuilder().id(Integer.parseInt(params.get("id")))
                .dateIn(Date.valueOf(params.get("dateIn")))
                .dateOut(Date.valueOf(params.get("dateOut")))
                .costAdditionalServices(Integer.parseInt(params.get("costAdditionalServices")))
                .user(new UserBuilder().id(Integer.parseInt(params.get("id_user"))).build())
                .discount(new DiscountBuilder().id(Integer.parseInt(params.get("id_discount"))).build())
                .build();
    }
}
