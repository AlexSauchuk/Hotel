package by.hotel.service.impl;

import by.hotel.bean.RoomType;
import by.hotel.builder.RoomTypeBuilder;
import by.hotel.dao.daoimpl.RoomTypeDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.AbstractService;
import by.hotel.service.CrudService;
import by.hotel.service.exception.IncorrectParkingSpaceLevelException;
import by.hotel.service.exception.IncorrectParkingSpaceRecervationException;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.validator.ValidatorParkingSpace;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class RoomTypeServiceImpl extends AbstractService implements CrudService<RoomType> {
    private RoomTypeDaoImpl roomTypeDao = new RoomTypeDaoImpl();

    public List<RoomType> getAllEntities() throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            return roomTypeDao.getRoomTypes(connection);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public void addEntity(RoomType entity) throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            roomTypeDao.addRoomType(entity, connection);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public void removeEntity(RoomType roomType) throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            roomTypeDao.removeRoomType(roomType, connection);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public void updateEntity(RoomType entity) throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            roomTypeDao.updateRoomType(entity, connection);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public RoomType buildEntity(Map<String, String[]> params) throws ServiceException, IncorrectParkingSpaceLevelException, IncorrectParkingSpaceRecervationException {
        ValidatorParkingSpace validatorParkingSpace = new ValidatorParkingSpace();
        if (validatorParkingSpace.validate(params)) {
            return new RoomTypeBuilder().id(Integer.parseInt(params.get("id")[0]))
                    .roomsCount(Integer.parseInt(params.get("rooms_count")[0]))
                    .bedsCount(Integer.parseInt(params.get("beds_count")[0]))
                    .costPerDay(Integer.parseInt(params.get("cost_per_day")[0]))
                    .additionalInfo(params.get("additional_info")[0])
                    .build();
        } else {
            return null;
        }
    }
}
