package by.hotel.dao.daoimpl;

import by.hotel.bean.Discount;
import by.hotel.bean.DiscountType;
import by.hotel.bean.Payment;
import by.hotel.bean.User;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.UserDao;
import by.hotel.dao.constants.Constants;
import by.hotel.dao.exception.DAOException;
import by.hotel.servlet.MainServlet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.hotel.dao.constants.Constants.*;

public class UserDaoImpl extends AbstractDao implements UserDao {
    private static final Logger logger = LogManager.getLogger(UserDaoImpl.class.getName());

    public List<User> getUsers() throws DAOException {
        Connection connection;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<User> users = new ArrayList<User>();
        try {
            connection = getConnection();
            statement = connection.prepareStatement(Constants.GET_ALL_USERS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                users.add(fillUser(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                finalize(statement);
            } catch (SQLException e) {
                logger.error(e);
            }
            return users;
        }
    }

    public void addUser(User user) throws DAOException {
        Connection connection;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(ADD_USER);
            statement = fillStatement(statement, user);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            finalize(statement);
        }
    }

    public void removeUser(User user) throws DAOException {
        Connection connection;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement.setInt(1, user.getId());
            statement = connection.prepareStatement(REMOVE_USER);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            finalize(statement);
        }
    }

    public void updateUser(User user) throws DAOException {
        Connection connection;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(UPDATE_USER);
            statement = fillStatement(statement, user);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            finalize(statement);
        }
    }

    public User getUser(Integer id) throws DAOException {
        Connection connection;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(Constants.GET_USER);
            resultSet = statement.executeQuery();
            user = fillUser(resultSet);
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                finalize(statement);
            } catch (SQLException e) {
                logger.error(e);
            }
        }
        return user;
    }

    private PreparedStatement fillStatement(PreparedStatement statement, User user) throws SQLException {
        statement.setString(1, user.getPassportNumber());
        statement.setString(2, user.getName());
        statement.setString(3, user.getSurname());
        statement.setString(4, user.getSex());
        statement.setString(5, user.getMobilePhone());
        statement.setString(6, user.getPassword());
        statement.setString(7, user.getLogin());
        return statement;
    }

    private User fillUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setPassportNumber(resultSet.getString("passport_number"));
        user.setName(resultSet.getString("name"));
        user.setSurname(resultSet.getString("surname"));
        user.setSex(resultSet.getString("sex"));
        user.setMobilePhone(resultSet.getString("mobile_phone"));
        user.setPassword(resultSet.getString("password"));
        user.setLogin(resultSet.getString("login"));
        return user;
    }
}
