package by.hotel.dao;

import by.hotel.bean.Role;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.util.List;

public interface RoleDao {
    List<String> getRoleHeaders(Connection connection) throws DAOException;
    List<Role> getRoles(Connection connection) throws DAOException;
    void addRole(Role role, Connection connection) throws DAOException;
    void removeRole(Role role, Connection connection) throws DAOException;
    void updateRole(Role role, Connection connection) throws DAOException;
    Role getLastInsertedRole(Connection connection) throws DAOException;

}
