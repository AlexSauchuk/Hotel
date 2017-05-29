package by.hotel.service.impl;

import by.hotel.bean.Reservation;
import by.hotel.builder.DiscountBuilder;
import by.hotel.builder.ReservationBuilder;
import by.hotel.builder.UserBuilder;
import by.hotel.dao.ReservationDao;
import by.hotel.dao.exception.DAOException;
import by.hotel.dao.impl.ReservationDaoImpl;
import by.hotel.service.AbstractService;
import by.hotel.service.CrudServiceExtended;
import by.hotel.service.exception.IncorrectCostException;
import by.hotel.service.exception.IncorrectDateException;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.validator.ValidatorReservation;

import java.sql.Connection;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

public class ReservationServiceImpl extends AbstractService implements CrudServiceExtended<Reservation> {
    ReservationDao reservationDao = new ReservationDaoImpl();

    public List<String> getAllHeaders() throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            return reservationDao.getReservationHeaders(connection);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            closeConnection(connection);
        }
    }

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

    public Reservation getEntity(Integer id) throws ServiceException {
        Connection connection = null;
        Reservation reservation;
        try {
            connection = getConnection();
            reservation = reservationDao.getReservation(id, connection);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            closeConnection(connection);
        }
        return reservation;
    }

    public List<Reservation> addEntity(Reservation entity) throws ServiceException {
        List<Reservation> reservations;
        Connection connection = null;
        try {
            connection = getConnection();
            reservationDao.addReservation(entity, connection);
            reservations = reservationDao.getAllReservations(connection);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            closeConnection(connection);
        }
        return reservations;
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

    public Reservation buildEntity(Map<String, String[]> params) throws ServiceException {
        ValidatorReservation validatorReservation = new ValidatorReservation();
        try {
            if (validatorReservation.validate(params)) {
                return new ReservationBuilder().id(Integer.parseInt(params.get("id")[0]))
                        .dateIn(new Date(new SimpleDateFormat("yyyy-MM-dd").parse(params.get("dateIn")[0]).getTime()))
                        .dateOut(new Date(new SimpleDateFormat("yyyy-MM-dd").parse(params.get("dateOut")[0]).getTime()))
                        .costAdditionalServices(Integer.parseInt(params.get("costAdditionalServices")[0]))
                        .user(new UserBuilder().id(Integer.parseInt(params.get("idUser")[0])).build())
                        .discount(new DiscountBuilder().id(Integer.parseInt(params.get("idDiscount")[0])).build())
                        .build();
            }
        } catch (ParseException | IncorrectDateException | IncorrectCostException e) {
            throw new ServiceException(e);
        }
        return null;
    }

    @Override
    public Reservation getLastInsertedEntity() throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            return reservationDao.getLastInsertedReservation(connection);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            closeConnection(connection);
        }
    }

}