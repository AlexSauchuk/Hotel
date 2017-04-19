package by.hotel.service.impl;

import by.hotel.bean.Reservation;
import by.hotel.builder.DiscountBuilder;
import by.hotel.builder.ReservationBuilder;
import by.hotel.builder.UserBuilder;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.daoimpl.ReservationDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.AbstractService;
import by.hotel.service.CrudService;
import by.hotel.service.exception.IncorrectParkingSpaceLevelException;
import by.hotel.service.exception.IncorrectParkingSpaceRecervationException;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.validator.ValidatorParkingSpace;

import java.sql.Connection;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

public class ReservationServiceImpl extends AbstractService implements CrudService<Reservation> {
    ReservationDaoImpl reservationDao = new ReservationDaoImpl();

    public List<Reservation> getAllEntities() throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            return reservationDao.getAllReservations(connection);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public void addEntity(Reservation entity) throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            reservationDao.addReservation(entity, connection);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public void removeEntity(Reservation reservation) throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            reservationDao.removeReservation(reservation, connection);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public void updateEntity(Reservation entity) throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            reservationDao.updateReservation(entity, connection);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public Reservation buildEntity(Map<String, String[]> params) throws ServiceException, IncorrectParkingSpaceLevelException, IncorrectParkingSpaceRecervationException {
        ValidatorParkingSpace validatorParkingSpace = new ValidatorParkingSpace();
        if (validatorParkingSpace.validate(params)) {
            Reservation reservation;
            try {
                reservation = new ReservationBuilder().id(Integer.parseInt(params.get("id")[0]))
                        .dateIn(new Date(new SimpleDateFormat("MMM dd, yyyy").parse(params.get("dateIn")[0]).getTime()))
                        .dateOut(new Date(new SimpleDateFormat("MMM dd, yyyy").parse(params.get("dateOut")[0]).getTime()))
                        .costAdditionalServices(Integer.parseInt(params.get("costAdditionalServices")[0]))
                        .user(new UserBuilder().id(Integer.parseInt(params.get("id_user")[0])).build())
                        .discount(new DiscountBuilder().id(Integer.parseInt(params.get("id_discount")[0])).build())
                        .build();
            } catch (ParseException e) {
                throw new ServiceException(e);
            }
            return reservation;
        } else {
            return null;
        }
    }
}
