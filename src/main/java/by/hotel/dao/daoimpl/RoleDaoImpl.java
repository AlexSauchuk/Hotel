package by.hotel.dao.daoimpl;

import by.hotel.bean.Role;
import by.hotel.builder.RoleBuilder;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.RoleDao;
import by.hotel.dao.constants.Constants;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.hotel.dao.constants.Constants.*;

public class RoleDaoImpl extends AbstractDao implements RoleDao {
    public List<Role> getRoles() throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Role> roles = new ArrayList<Role>();
        RoleBuilder roleBuilder = new RoleBuilder();
        try {
            connection = getConnection();
            statement = connection.prepareStatement(Constants.GET_ALL_ROLES);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                roles.add(roleBuilder.id(resultSet.getInt("id"))
                        .nameRole(resultSet.getString("name_role"))
                        .update(resultSet.getByte("update"))
                        .delete(resultSet.getByte("delete"))
                        .insert(resultSet.getByte("insert"))
                        .create(resultSet.getByte("create"))
                        .select(resultSet.getByte("select"))
                        .drop(resultSet.getByte("drop"))
                        .grant(resultSet.getByte("grant"))
                        .build());
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeConnection(connection, statement, resultSet);
        }
        return roles;
    }

    public void addRole(Role role) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(ADD_ROLE);
            statement = fillStatement(statement, role);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeConnection(connection, statement, null);
        }
    }

    public void removeRole(Role role) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(REMOVE_ROLE);
            statement.setInt(1, role.getId());
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeConnection(connection, statement, null);
        }
    }

    public void updateRole(Role role) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(UPDATE_ROLE);
            statement = fillStatement(statement, role);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeConnection(connection, statement, null);
        }
    }

    private PreparedStatement fillStatement(PreparedStatement statement, Role role) throws SQLException {
        statement.setString(1, role.getNameRole());
        statement.setInt(2, role.getUpdate());
        statement.setInt(3, role.getDelete());
        statement.setInt(4, role.getInsert());
        statement.setInt(5, role.getCreate());
        statement.setInt(6, role.getSelect());
        statement.setInt(7, role.getDrop());
        statement.setInt(8, role.getGrant());
        return statement;
    }
}