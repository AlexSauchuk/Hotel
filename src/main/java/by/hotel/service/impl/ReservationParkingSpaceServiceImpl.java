package by.hotel.service.impl;
import by.hotel.bean.Reservation;
import by.hotel.bean.ReservationParkingSpace;
import by.hotel.builder.ParkingSpaceBuilder;
import by.hotel.builder.ReservationBuilder;
import by.hotel.builder.ReservationParkingSpaceBuilder;
import by.hotel.dao.daoimpl.ReservationParkingSpaceDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.AbstractService;
import by.hotel.service.CrudService;
import by.hotel.service.exception.ServiceException;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class ReservationParkingSpaceServiceImpl extends AbstractService implements CrudService<ReservationParkingSpace> {
    ReservationParkingSpaceDaoImpl reservationParkingSpaceDao = new ReservationParkingSpaceDaoImpl();

    public List<ReservationParkingSpace> getAllEntities() throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            return reservationParkingSpaceDao.getReservationParkingSpaces(getConnection());
        }catch (DAOException e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
    }

    public void addEntity(ReservationParkingSpace entity) throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            reservationParkingSpaceDao.addReservationParkingSpace(entity,getConnection());
        }catch (DAOException e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
    }

    public void removeEntity(ReservationParkingSpace reservationParkingSpace) throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            reservationParkingSpaceDao.removeReservationParkingSpace(reservationParkingSpace,getConnection());
        }catch (DAOException e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
    }

    public void updateEntity(ReservationParkingSpace entity) throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            reservationParkingSpaceDao.updateReservationParkingSpace(entity,getConnection());
        }catch (DAOException e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
    }

    public ReservationParkingSpace buildEntity(Map<String, String[]> params) throws ServiceException {
        return new ReservationParkingSpaceBuilder()
                .reservation(new ReservationBuilder().id(Integer.parseInt(params.get("id_reservation")[0])).build())
                .parkingSpace(new ParkingSpaceBuilder().id(Integer.parseInt(params.get("id_parkingSpace")[0])).build())
                .build();
    }
}
