package by.hotel.service.impl;

import by.hotel.bean.RoomType;
import by.hotel.builder.RoomTypeBuilder;
import by.hotel.dao.RoomTypeDao;
import by.hotel.dao.impl.RoomTypeDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.AbstractService;
import by.hotel.service.CrudServiceExtended;
import by.hotel.service.exception.*;
import by.hotel.service.validator.ValidatorRoom;
import by.hotel.service.validator.ValidatorRoomType;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class RoomTypeServiceImpl extends AbstractService implements CrudServiceExtended<RoomType> {
    private RoomTypeDao roomTypeDao = new RoomTypeDaoImpl();

    public List<String> getAllHeaders() throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            return roomTypeDao.getRoomTypeHeaders(connection);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            closeConnection(connection);
        }
    }

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

    public List<RoomType> addEntity(RoomType entity) throws ServiceException {
        Connection connection = null;
        List<RoomType> roomTypes;
        try {
            connection = getConnection();
            roomTypeDao.addRoomType(entity, connection);
            roomTypes = roomTypeDao.getRoomTypes(connection);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            closeConnection(connection);
        }
        return roomTypes;
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

    public RoomType buildEntity(Map<String, String[]> params) throws ServiceException {
        ValidatorRoomType validatorRoomType = new ValidatorRoomType();
        try {
            if (validatorRoomType.validate(params)) {
                return new RoomTypeBuilder().id(Integer.parseInt(params.get("id")[0]))
                        .roomsCount(Integer.parseInt(params.get("roomsCount")[0]))
                        .bedsCount(Integer.parseInt(params.get("bedsCount")[0]))
                        .costPerDay(Float.parseFloat(params.get("costPerDay")[0]))
                        .additionalInfo(params.get("additionalInfo")[0])
                        .bathroomsCount(Integer.parseInt(params.get("bathroomsCount")[0]))
                        .size(Integer.parseInt(params.get("size")[0]))
                        .build();
            }
        } catch (IncorrectRoomBedsException | IncorrectCostException
                | IncorrectRoomsCountException | IncorrectRoomBathroomsException
                | IncorrectRoomAdditionalInfoException | IncorrectRoomSizeException e) {
            throw new ServiceException(e);
        }
        return null;
    }

    @Override
    public RoomType getLastInsertedEntity() throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            return roomTypeDao.getLastInsertedRoomType(connection);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            closeConnection(connection);
        }
    }

}