package by.hotel.service.impl;

import by.hotel.bean.ReservationParkingSpace;
import by.hotel.builder.ParkingSpaceBuilder;
import by.hotel.builder.ReservationBuilder;
import by.hotel.builder.ReservationParkingSpaceBuilder;
import by.hotel.dao.ReservationParkingSpaceDao;
import by.hotel.dao.impl.ReservationParkingSpaceDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.AbstractService;
import by.hotel.service.CrudService;
import by.hotel.service.exception.ServiceException;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class ReservationParkingSpaceServiceImpl extends AbstractService implements CrudService<ReservationParkingSpace> {
    ReservationParkingSpaceDao reservationParkingSpaceDao = new ReservationParkingSpaceDaoImpl();

    public List<ReservationParkingSpace> getAllEntities() throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            return reservationParkingSpaceDao.getReservationParkingSpaces(connection);
        }catch (DAOException e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
    }

    public List<ReservationParkingSpace> addEntity(ReservationParkingSpace entity) throws ServiceException {
        List<ReservationParkingSpace> reservationParkingSpaces;
        Connection connection = null;
        try {
            connection = getConnection();
            reservationParkingSpaceDao.addReservationParkingSpace(entity,connection);
            reservationParkingSpaces = reservationParkingSpaceDao.getReservationParkingSpaces(connection);
        }catch (DAOException e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
        return reservationParkingSpaces;
    }

    public void removeEntity(ReservationParkingSpace reservationParkingSpace) throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            reservationParkingSpaceDao.removeReservationParkingSpace(reservationParkingSpace,connection);
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
            reservationParkingSpaceDao.updateReservationParkingSpace(entity,connection);
        }catch (DAOException e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
    }

    public ReservationParkingSpace buildEntity(Map<String, String[]> params) throws ServiceException {
        return new ReservationParkingSpaceBuilder()
                .reservation(new ReservationBuilder().id(Integer.parseInt(params.get("idReservation")[0])).build())
                .parkingSpace(new ParkingSpaceBuilder().id(Integer.parseInt(params.get("idParkingSpace")[0])).build())
                .build();
    }

    @Override
    public ReservationParkingSpace getLastInsertedEntity() throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            return reservationParkingSpaceDao.getLastInsertedReservationParkingSpace(connection);
        }catch (DAOException e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
    }

}