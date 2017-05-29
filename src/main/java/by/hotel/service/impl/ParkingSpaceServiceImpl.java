package by.hotel.service.impl;


import by.hotel.bean.ParkingSpace;
import by.hotel.builder.ParkingSpaceBuilder;
import by.hotel.dao.ParkingSpaceDao;
import by.hotel.dao.impl.ParkingSpaceDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.AbstractService;
import by.hotel.service.CrudServiceExtended;
import by.hotel.service.exception.IncorrectParkingSpaceLevelException;
import by.hotel.service.exception.IncorrectParkingSpaceReservationException;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.validator.ValidatorParkingSpace;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class ParkingSpaceServiceImpl extends AbstractService implements CrudServiceExtended<ParkingSpace> {
    private ParkingSpaceDao parkingSpaceDao = new ParkingSpaceDaoImpl();

    public List<String> getAllHeaders() throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            return parkingSpaceDao.getParkingSpaceHeaders(connection);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<ParkingSpace> getAllEntities() throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            return parkingSpaceDao.getParkingSpaces(connection);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<ParkingSpace> addEntity(ParkingSpace entity) throws ServiceException {
        List<ParkingSpace> parkingSpaces;
        Connection connection = null;
        try {
            connection = getConnection();
            parkingSpaceDao.addParkingSpace(entity, connection);
            parkingSpaces = parkingSpaceDao.getParkingSpaces(connection);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            closeConnection(connection);
        }
        return parkingSpaces;
    }

    public void removeEntity(ParkingSpace parkingSpace) throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            parkingSpaceDao.removeParkingSpace(parkingSpace, connection);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public void updateEntity(ParkingSpace entity) throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            parkingSpaceDao.updateParkingSpace(entity, connection);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public ParkingSpace buildEntity(Map<String, String[]> params) throws ServiceException {
        ValidatorParkingSpace validatorParkingSpace = new ValidatorParkingSpace();
        try {
            if (validatorParkingSpace.validate(params)) {
                return new ParkingSpaceBuilder().id(Integer.parseInt(params.get("id")[0]))
                        .level(Integer.parseInt(params.get("level")[0]))
                        .reserved(Byte.parseByte(params.get("reserved")[0]))
                        .build();
            }
        } catch (IncorrectParkingSpaceLevelException | IncorrectParkingSpaceReservationException e) {
            throw new ServiceException(e);
        }
        return null;

    }

    @Override
    public ParkingSpace getLastInsertedEntity() throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            return parkingSpaceDao.getLastInsertedParkingSpace(connection);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            closeConnection(connection);
        }
    }


}