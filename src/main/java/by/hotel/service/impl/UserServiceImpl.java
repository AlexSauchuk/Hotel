package by.hotel.service.impl;

import by.hotel.bean.User;
import by.hotel.builder.RoleBuilder;
import by.hotel.builder.RoomTypeBuilder;
import by.hotel.builder.UserBuilder;
import by.hotel.dao.UserDao;
import by.hotel.dao.daoimpl.UserDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.AbstractService;
import by.hotel.service.CrudService;
import by.hotel.service.exception.IncorrectParkingSpaceLevelException;
import by.hotel.service.exception.IncorrectParkingSpaceRecervationException;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.validator.ValidatorParkingSpace;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl extends AbstractService implements CrudService<User> {
    private UserDao userDao = new UserDaoImpl();

    public List<User> getAllEntities() throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            return userDao.getUsers(connection);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public void addEntity(User entity) throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            userDao.addUser(entity, connection);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public void removeEntity(User user) throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            userDao.removeUser(user, connection);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public void updateEntity(User entity) throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            userDao.updateUser(entity, connection);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public User buildEntity(Map<String, String[]> params) throws ServiceException, IncorrectParkingSpaceLevelException, IncorrectParkingSpaceRecervationException {
        ValidatorParkingSpace validatorParkingSpace = new ValidatorParkingSpace();
        if (validatorParkingSpace.validate(params)) {
            return new UserBuilder().id(Integer.parseInt(params.get("id")[0]))
                    .name(params.get("name")[0])
                    .surname(params.get("surname")[0])
                    .passportNumber(params.get("passport_number")[0])
                    .login(params.get("login")[0])
                    .password(params.get("password")[0])
                    .passportNumber(params.get("passport_number")[0])
                    .sex(params.get("sex")[0])
                    .role(new RoleBuilder().id(Integer.parseInt(params.get("id_role")[0])).build())
                    .build();
        } else {
            return null;
        }
    }
}