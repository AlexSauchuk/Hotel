package by.hotel.service.impl;
import by.hotel.bean.Reservation;
import by.hotel.bean.ReservationParkingSpace;
import by.hotel.builder.ParkingSpaceBuilder;
import by.hotel.builder.ReservationBuilder;
import by.hotel.builder.ReservationParkingSpaceBuilder;
import by.hotel.dao.daoimpl.ReservationParkingSpaceDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.CrudService;
import by.hotel.service.exception.ServiceException;

import java.util.List;
import java.util.Map;

public class ReservationParkingSpaceServiceImpl implements CrudService<ReservationParkingSpace> {
    ReservationParkingSpaceDaoImpl reservationParkingSpaceDao = new ReservationParkingSpaceDaoImpl();

    public List<Integer> getAllId() throws ServiceException {
        try {
            return reservationParkingSpaceDao.getId();
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public List<ReservationParkingSpace> getAllEntities() throws ServiceException {
        try {
            return reservationParkingSpaceDao.getReservationParkingSpaces();
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public void addEntity(ReservationParkingSpace entity) throws ServiceException {
        try {
            reservationParkingSpaceDao.addReservationParkingSpace(entity);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public void removeEntity(ReservationParkingSpace reservationParkingSpace) throws ServiceException {
        try {
            reservationParkingSpaceDao.removeReservationParkingSpace(reservationParkingSpace);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public void updateEntity(ReservationParkingSpace entity) throws ServiceException {
        try {
            reservationParkingSpaceDao.updateReservationParkingSpace(entity);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public ReservationParkingSpace buildEntity(Map<String, String[]> params) throws ServiceException {
        return new ReservationParkingSpaceBuilder()
                .reservation(new ReservationBuilder().id(Integer.parseInt(params.get("id_reservation")[0])).build())
                .parkingSpace(new ParkingSpaceBuilder().id(Integer.parseInt(params.get("id_parkingSpace")[0])).build())
                .build();
    }
}
