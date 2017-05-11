package by.hotel.dao.impl;

import by.hotel.bean.Role;
import by.hotel.bean.User;
import by.hotel.builder.RoleBuilder;
import by.hotel.builder.UserBuilder;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.RoleDao;
import by.hotel.dao.constants.Constants;
import by.hotel.dao.exception.DAOException;
import by.hotel.util.ErrorStringBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.hotel.dao.constants.Constants.*;

public class RoleDaoImpl extends AbstractDao implements RoleDao {
    public List<String> getRoleHeaders(Connection connection) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<String> headers = new ArrayList<String>();
        StringBuilder stringBuilder = new StringBuilder();
        try {
            statement = connection.prepareStatement(GET_ALL_ROLES_HEADERS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                stringBuilder.append(resultSet.getInt("id")+" ");
                stringBuilder.append(resultSet.getString("nameRole"));
                headers.add(stringBuilder.toString());
                stringBuilder.setLength(0);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, resultSet);
        }
        return headers;
    }

    public List<Role> getRoles(Connection connection) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Role> roles = new ArrayList<Role>();
        RoleBuilder roleBuilder = new RoleBuilder();
        try {
            statement = connection.prepareStatement(GET_ALL_ROLES);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                roles.add(roleBuilder.id(resultSet.getInt("id"))
                        .nameRole(resultSet.getString("nameRole"))
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

            closeStatement(statement, resultSet);
        }
        return roles;
    }

    public void addRole(Role role,Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(ADD_ROLE);
            statement = fillStatement(statement, role);
            statement.execute();
        } catch (SQLException | NullPointerException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
    }

    public void removeRole(Role role,Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(REMOVE_ROLE);
            statement.setInt(1, role.getId());
            statement.execute();
        }catch (SQLIntegrityConstraintViolationException e){
            throw new DAOException(buildMessage(role, e.getMessage()) ,e);
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
    }

    public void updateRole(Role role,Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(UPDATE_ROLE);
            statement = fillStatement(statement, role);
            statement.setInt(9, role.getId());
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
    }

    @Override
    public Role getLastInsertedRole(Connection connection) throws DAOException {
        PreparedStatement statement = null;
        Role role = null;
        ResultSet resultSet;
        RoleBuilder roleBuilder = new RoleBuilder();
        try {
            statement = connection.prepareStatement(GET_LAST_INSERTED_ROLE);
            // statement.setString(1,"role");
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                role = fillRole(resultSet, roleBuilder);
            }
        } catch (SQLException | NullPointerException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
        return role;
    }

    private Role fillRole(ResultSet resultSet, RoleBuilder roleBuilder) throws SQLException {
        return roleBuilder.id(resultSet.getInt("id"))
                .nameRole(resultSet.getString("nameRole"))
                .update(resultSet.getByte("update"))
                .delete(resultSet.getByte("delete"))
                .insert(resultSet.getByte("insert"))
                .create(resultSet.getByte("create"))
                .select(resultSet.getByte("select"))
                .drop(resultSet.getByte("drop"))
                .grant(resultSet.getByte("grant"))
                .build();
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

    private String buildMessage(Role role, String errorMessage){
        Map<String,String> idNames = new HashMap<String, String>();
        idNames.put("id",Integer.toString(role.getId()));
        return ErrorStringBuilder.buildDeleteErrorString(idNames,errorMessage);
    }
}
