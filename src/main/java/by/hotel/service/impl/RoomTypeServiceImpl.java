package by.hotel.service.impl;

import by.hotel.bean.RoomType;
import by.hotel.builder.RoomTypeBuilder;
import by.hotel.dao.daoimpl.RoomTypeDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.AbstractService;
import by.hotel.service.CrudServiceExtended;
import by.hotel.service.exception.ServiceException;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class RoomTypeServiceImpl extends AbstractService implements CrudServiceExtended<RoomType> {
    private RoomTypeDaoImpl roomTypeDao = new RoomTypeDaoImpl();

    public List<String> getAllHeaders() throws ServiceException {
        try {
            return roomTypeDao.getRoomTypeHeaders();
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public List<RoomType> getAllEntities() throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            return roomTypeDao.getRoomTypes(getConnection());
        }catch (DAOException e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
    }

    public void addEntity(RoomType entity) throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            roomTypeDao.addRoomType(entity,getConnection());
        }catch (DAOException e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
    }

    public void removeEntity(RoomType roomType) throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            roomTypeDao.removeRoomType(roomType,getConnection());
        }catch (DAOException e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
    }

    public void updateEntity(RoomType entity) throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            roomTypeDao.updateRoomType(entity,getConnection());
        }catch (DAOException e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
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
