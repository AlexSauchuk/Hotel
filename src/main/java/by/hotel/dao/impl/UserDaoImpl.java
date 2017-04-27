package by.hotel.dao.impl;

import by.hotel.bean.Reservation;
import by.hotel.bean.User;
import by.hotel.builder.ReservationBuilder;
import by.hotel.builder.RoleBuilder;
import by.hotel.builder.UserBuilder;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.AuthDao;
import by.hotel.dao.UserDao;
import by.hotel.dao.constants.Constants;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.hotel.dao.constants.Constants.*;

public class UserDaoImpl extends AbstractDao implements UserDao,AuthDao {
    public List<String> getUserHeaders(Connection connection) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<String> headers = new ArrayList<String>();
        StringBuilder stringBuilder = new StringBuilder();
        try {
            statement = connection.prepareStatement(GET_ALL_USERS_HEADERS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                stringBuilder.append(resultSet.getInt("id")+" ");
                stringBuilder.append(resultSet.getString("surname")+" ");
                stringBuilder.append(resultSet.getString("name"));
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

    public List<User> getUsers(Connection connection) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<User> users = new ArrayList<User>();
        UserBuilder userBuilder = new UserBuilder();
        try {
            statement = connection.prepareStatement(GET_ALL_USERS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                users.add(fillUser(resultSet, userBuilder));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, resultSet);
        }
        return users;
    }

    public void addUser(User user,Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(ADD_USER);
            statement = fillStatement(statement, user);
            statement.execute();
        } catch (SQLException | NullPointerException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
    }

    public void removeUser(User user,Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(REMOVE_USER);
            statement.setInt(1, user.getId());
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
    }

    public void updateUser(User user,Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(UPDATE_USER);
            statement = fillStatement(statement, user);
            statement.setInt(9, user.getId());
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
    }

    public User getUser(Integer id,Connection connection) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user;
        UserBuilder userBuilder = new UserBuilder();
        try {
            statement = connection.prepareStatement(GET_USER);
            resultSet = statement.executeQuery();
            user = fillUser(resultSet, userBuilder);
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, resultSet);
        }
        return user;
    }

    @Override
    public User getLastInsertedUser(Connection connection) throws DAOException {
        PreparedStatement statement = null;
        User user = null;
        ResultSet resultSet;
        UserBuilder userBuilder = new UserBuilder();
        try {
            statement = connection.prepareStatement(GET_LAST_INSERTED_USER);
            // statement.setString(1,"user");
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = fillUser(resultSet, userBuilder);
            }
        } catch (SQLException | NullPointerException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
        return user;
    }

    public User authorisation(String login, String password, Connection connection) throws DAOException{
        User user = new User();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(Constants.AUTH_USER);
            statement = fillStatement(statement, login,password);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                return user;
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        finally {
            closeStatement(statement, resultSet);
        }
        return user;
    }

    private PreparedStatement fillStatement(PreparedStatement statement, String login, String password) throws SQLException {
        statement.setString(1, login);
        statement.setString(2, password);
        return statement;
    }

    private PreparedStatement fillStatement(PreparedStatement statement, User user) throws SQLException {
        statement.setString(1, user.getPassportNumber());
        statement.setString(2, user.getName());
        statement.setString(3, user.getSurname());
        statement.setString(4, user.getSex());
        statement.setString(5, user.getMobilePhone());
        statement.setString(6, user.getPassword());
        statement.setString(7, user.getLogin());
        statement.setInt(8, user.getRole().getId());
        return statement;
    }

    private User fillUser(ResultSet resultSet, UserBuilder userBuilder) throws SQLException {
        RoleBuilder roleBuilder = new RoleBuilder();
        return userBuilder.id(resultSet.getInt("id"))
                .passportNumber(resultSet.getString("passport_number"))
                .name(resultSet.getString("name"))
                .surname(resultSet.getString("surname"))
                .sex(resultSet.getString("sex"))
                .mobilePhone(resultSet.getString("mobile_phone"))
                .password(resultSet.getString("password"))
                .login(resultSet.getString("login"))
                .role(roleBuilder.id(resultSet.getInt("id_role"))
                        .nameRole(resultSet.getString("name_role"))
                        .update(resultSet.getByte("update"))
                        .delete(resultSet.getByte("delete"))
                        .insert(resultSet.getByte("insert"))
                        .create(resultSet.getByte("create"))
                        .select(resultSet.getByte("select"))
                        .drop(resultSet.getByte("drop"))
                        .grant(resultSet.getByte("grant")).build())
                .build();
    }
}