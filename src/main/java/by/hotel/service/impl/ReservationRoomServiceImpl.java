package by.hotel.service.impl;

import by.hotel.bean.ReservationRoom;
import by.hotel.builder.ReservationBuilder;
import by.hotel.builder.ReservationRoomBuilder;
import by.hotel.builder.RoomBuilder;
import by.hotel.dao.ReservationRoomDao;
import by.hotel.dao.impl.ReservationRoomDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.AbstractService;
import by.hotel.service.CrudService;
import by.hotel.service.exception.ServiceException;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class ReservationRoomServiceImpl extends AbstractService implements CrudService<ReservationRoom> {
    ReservationRoomDao reservationRoomDao = new ReservationRoomDaoImpl();

    public List<ReservationRoom> getAllEntities() throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            return reservationRoomDao.getReservationRooms(connection);
        }catch (DAOException e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
    }

    public List<ReservationRoom> addEntity(ReservationRoom entity) throws ServiceException {
        List<ReservationRoom> reservationRooms;
        Connection connection = null;
        try {
            connection = getConnection();
            reservationRoomDao.addReservationRoom(entity,connection);
            reservationRooms = reservationRoomDao.getReservationRooms(connection);
        }catch (DAOException e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
        return reservationRooms;
    }

    public void removeEntity(ReservationRoom reservationRoom) throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            reservationRoomDao.removeReservationRoom(reservationRoom,connection);
        }catch (DAOException e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
    }

    public void updateEntity(ReservationRoom entity) throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            reservationRoomDao.updateReservationRoom(entity,connection);
        }catch (DAOException e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
    }

    public ReservationRoom buildEntity(Map<String, String[]> params) throws ServiceException {
        return new ReservationRoomBuilder()
                .reservation(new ReservationBuilder().id(Integer.parseInt(params.get("idReservation")[0])).build())
                .room(new RoomBuilder().id(Integer.parseInt(params.get("idRoom")[0])).build())
                .build();
    }

    @Override
    public ReservationRoom getLastInsertedEntity() throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            return reservationRoomDao.getLastInsertedReservationRoom(connection);
        }catch (DAOException e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
    }

}
