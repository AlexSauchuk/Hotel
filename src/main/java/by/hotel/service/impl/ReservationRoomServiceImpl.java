package by.hotel.service.impl;

import by.hotel.bean.ReservationRoom;
import by.hotel.builder.ReservationBuilder;
import by.hotel.builder.ReservationRoomBuilder;
import by.hotel.builder.RoomBuilder;
import by.hotel.dao.daoimpl.ReservationRoomDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.CrudService;
import by.hotel.service.exception.ServiceException;

import java.util.List;
import java.util.Map;

public class ReservationRoomServiceImpl implements CrudService<ReservationRoom> {
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

    public void removeEntity(ReservationRoom reservationRoom) throws ServiceException {
        try {
            reservationRoomDao.removeReservationRoom(reservationRoom);
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

    public ReservationRoom buildEntity(Map<String, String[]> params) throws ServiceException {
        return new ReservationRoomBuilder()
                .reservation(new ReservationBuilder().id(Integer.parseInt(params.get("id_reservation")[0])).build())
                .room(new RoomBuilder().id(Integer.parseInt(params.get("id_room")[0])).build())
                .build();
    }
}
