package by.hotel.dao;

import by.hotel.bean.Role;
import by.hotel.bean.Room;
import by.hotel.dao.exception.DAOException;

import java.util.List;

/**
 * Created by 1 on 17.04.2017.
 */
public interface RoleDao {
    List<Role> getRoles() throws DAOException;

    void addRole(Role role) throws DAOException;

    void removeRole(Role role) throws DAOException;

    void updateRole(Role role) throws DAOException;
}
