package by.hotel.service.impl;

import by.hotel.bean.Room;
import by.hotel.bean.RoomType;
import by.hotel.dao.daoimpl.RoomDaoImpl;
import by.hotel.dao.daoimpl.RoomTypeDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.CrudService;
import by.hotel.service.exception.ServiceException;

import java.util.List;

/**
 * Created by 1 on 07.04.2017.
 */
public class RoomTypeServiceImpl implements CrudService<RoomType> {
    private RoomTypeDaoImpl roomTypeDao = new RoomTypeDaoImpl();

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

    public void removeEntity(RoomType entity) throws ServiceException {
        try {
            roomTypeDao.removeRoomType(entity);
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
}
