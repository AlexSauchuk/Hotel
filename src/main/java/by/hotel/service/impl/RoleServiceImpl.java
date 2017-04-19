package by.hotel.service.impl;

import by.hotel.bean.Role;
import by.hotel.builder.RoleBuilder;
import by.hotel.dao.RoleDao;
import by.hotel.dao.daoimpl.RoleDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.CrudService;
import by.hotel.service.exception.ServiceException;

import java.util.List;
import java.util.Map;

public class RoleServiceImpl implements CrudService<Role> {
    private RoleDao roleDao = new RoleDaoImpl();

    public List<Integer> getAllId() throws ServiceException {
        return null;
    }

    public List<Role> getAllEntities() throws ServiceException {
        try {
            return roleDao.getRoles();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void addEntity(Role entity) throws ServiceException {
        try {
            roleDao.addRole(entity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void removeEntity(Role entity) throws ServiceException {
        try {
            roleDao.removeRole(entity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void updateEntity(Role entity) throws ServiceException {
        try {
            roleDao.updateRole(entity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public Role buildEntity(Map<String, String[]> params) throws ServiceException {
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
}
