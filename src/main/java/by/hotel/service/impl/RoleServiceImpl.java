package by.hotel.service.impl;

import by.hotel.bean.ReservationRoom;
import by.hotel.bean.Role;
import by.hotel.builder.RoleBuilder;
import by.hotel.dao.RoleDao;
import by.hotel.dao.impl.RoleDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.AbstractService;
import by.hotel.service.CrudServiceExtended;
import by.hotel.service.exception.*;
import by.hotel.service.validator.ValidatorParkingSpace;
import by.hotel.service.validator.ValidatorRole;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class RoleServiceImpl extends AbstractService implements CrudServiceExtended<Role> {
    private RoleDao roleDao = new RoleDaoImpl();

    public List<String> getAllHeaders() throws ServiceException {
        Connection connection = null;
        try{
            connection = getConnection();
            return roleDao.getRoleHeaders(connection);
        }catch (DAOException e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
    }

    public List<Role> getAllEntities() throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            return roleDao.getRoles(connection);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
    }

    public List<Role> addEntity(Role entity) throws ServiceException {
        Connection connection = null;
        List<Role> roles;
        try {
            connection = getConnection();
            roleDao.addRole(entity,connection);
            roles = roleDao.getRoles(connection);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
        return roles;
    }

    public void removeEntity(Role entity) throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            roleDao.removeRole(entity,connection);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
    }

    public void updateEntity(Role entity) throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            roleDao.updateRole(entity,connection);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
    }

    public Role buildEntity(Map<String, String[]> params) throws ServiceException {
        ValidatorRole validatorRole = new ValidatorRole();
        try {
            if (validatorRole.validate(params)) {
                return new RoleBuilder().id(Integer.parseInt(params.get("id")[0]))
                        .nameRole(params.get("nameRole")[0])
                        .update(Byte.parseByte(params.get("update")[0]))
                        .delete(Byte.parseByte(params.get("delete")[0]))
                        .insert(Byte.parseByte(params.get("insert")[0]))
                        .create(Byte.parseByte(params.get("create")[0]))
                        .select(Byte.parseByte(params.get("select")[0]))
                        .drop(Byte.parseByte(params.get("drop")[0]))
                        .grant(Byte.parseByte(params.get("grant")[0]))
                        .build();
            }
        }catch (IncorrectNameRoleException | IncorrectRightRoleException e) {
            throw new ServiceException(e);
        }
        return null;
    }

    @Override
    public Role getLastInsertedEntity() throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            return roleDao.getLastInsertedRole(connection);
        }catch (DAOException e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
    }


}