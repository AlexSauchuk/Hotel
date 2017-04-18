package by.hotel.service.impl;

import by.hotel.bean.RoomType;
import by.hotel.builder.RoomTypeBuilder;
import by.hotel.dao.daoimpl.RoomTypeDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.CrudServiceExtended;
import by.hotel.service.exception.ServiceException;

import java.util.List;
import java.util.Map;

public class RoomTypeServiceImpl implements CrudServiceExtended<RoomType> {
    private RoomTypeDaoImpl roomTypeDao = new RoomTypeDaoImpl();

    public List<String> getAllHeaders() throws ServiceException {
        try {
            return roomTypeDao.getRoomTypeHeaders();
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public List<RoomType> getAllEntities() throws ServiceException {
        try {
            return roomTypeDao.getRoomTypes();
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public void addEntity(RoomType entity) throws ServiceException {
        try {
            roomTypeDao.addRoomType(entity);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public void removeEntity(RoomType roomType) throws ServiceException {
        try {
            roomTypeDao.removeRoomType(roomType);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public void updateEntity(RoomType entity) throws ServiceException {
        try {
            roomTypeDao.updateRoomType(entity);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public RoomType buildEntity(Map<String, String[]> params) throws ServiceException {
        return new RoomTypeBuilder().id(Integer.parseInt(params.get("id")[0]))
                .roomsCount(Integer.parseInt(params.get("roomsCount")[0]))
                .bedsCount(Integer.parseInt(params.get("bedsCount")[0]))
                .costPerDay(Integer.parseInt(params.get("costPerDay")[0]))
                .additionalInfo(params.get("additionalInfo")[0])
                .build();
    }
}
