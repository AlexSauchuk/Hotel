package by.hotel.service.impl;

import by.hotel.bean.Room;
import by.hotel.builder.RoomBuilder;
import by.hotel.builder.RoomTypeBuilder;
import by.hotel.dao.RoomDao;
import by.hotel.dao.impl.RoomDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.AbstractService;
import by.hotel.service.CrudServiceExtended;
import by.hotel.service.exception.IncorrectRoomNameException;
import by.hotel.service.exception.IncorrectRoomPathException;
import by.hotel.service.exception.IncorrectRoomPhoneNumberException;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.validator.ValidatorRole;
import by.hotel.service.validator.ValidatorRoom;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class RoomServiceImpl extends AbstractService implements CrudServiceExtended<Room> {
    private RoomDao roomDao = new RoomDaoImpl();

    public List<String> getAllHeaders() throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            return roomDao.getRoomHeaders(connection);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<Room> getAllEntities() throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            return roomDao.getRooms(connection);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<Room> addEntity(Room entity) throws ServiceException {
        List<Room> rooms;
        Connection connection = null;
        try {
            connection = getConnection();
            roomDao.addRoom(entity, connection);
            rooms = roomDao.getRooms(connection);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            closeConnection(connection);
        }
        return rooms;
    }

    public void removeEntity(Room room) throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            roomDao.removeRoom(room, connection);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public void updateEntity(Room entity) throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            roomDao.updateRoom(entity, connection);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public Room buildEntity(Map<String, String[]> params) throws ServiceException {
        ValidatorRoom validatorRoom = new ValidatorRoom();
        try {
            if (validatorRoom.validate(params)) {
                return new RoomBuilder().id(Integer.parseInt(params.get("id")[0]))
                        .roomType(new RoomTypeBuilder().id(Integer.parseInt(params.get("idRoomType")[0]))
                                .build())
                        .name(params.get("name")[0])
                        .floor(Integer.parseInt(params.get("floor")[0]))
                        .phone(params.get("phone")[0])
                        .path(params.get("path")[0])
                        .build();
            }
        }catch (IncorrectRoomPhoneNumberException | IncorrectRoomNameException | IncorrectRoomPathException e) {
            throw new ServiceException(e);
        }
        return null;
    }

    @Override
    public Room getLastInsertedEntity() throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            return roomDao.getLastInsertedRoom(connection);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            closeConnection(connection);
        }
    }
}