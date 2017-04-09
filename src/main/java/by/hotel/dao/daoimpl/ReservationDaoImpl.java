package by.hotel.dao.daoimpl;


import by.hotel.bean.Reservation;
import by.hotel.bean.Room;
import by.hotel.bean.RoomType;
import by.hotel.bean.User;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.ReservationDao;
import by.hotel.dao.constants.Constants;
import by.hotel.dao.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.hotel.dao.constants.Constants.*;

public class ReservationDaoImpl extends AbstractDao implements ReservationDao {
    private static final Logger logger = LogManager.getLogger(ReservationDaoImpl.class.getName());

    public List<Reservation> getAllReservations() throws DAOException {
        Connection connection;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Reservation> reservations = new ArrayList<Reservation>();
        try {
            connection = getConnection();
            statement = connection.prepareStatement(Constants.GET_ALL_RESERVATIONS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Reservation reservation = new Reservation();
                User user = new User();
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setMobilePhone(resultSet.getString("mobilePhone"));
                user.setPassportNumber(resultSet.getString("passportNumber"));
                user.setSex(resultSet.getString("sex"));
                reservation.setUser(user);
                reservation.setRoomNumber(resultSet.getInt("room_number"));
                reservation.setDateIn(resultSet.getDate("date-in"));
                reservation.setDateOut(resultSet.getDate("date-out"));
                reservation.setDaysCount(resultSet.getInt("days_count"));

                reservations.add(reservation);
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
        }
        return reservations;
    }

    public void addReservation(Reservation reservation) throws DAOException {
        Connection connection;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(ADD_RESERVATION);
            statement = fillStatement(statement, reservation);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            finalize(statement);
        }
    }

    public void removeReservation(Reservation reservation) throws DAOException {
        Connection connection;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement.setInt(1, reservation.getId());
            statement = connection.prepareStatement(REMOVE_RESERVATION);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            finalize(statement);
        }
    }

    public void updateReservation(Reservation reservation) throws DAOException {
        Connection connection;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(UPDATE_RESERVATION);
            statement = fillStatement(statement, reservation);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            finalize(statement);
        }
    }

    public Reservation getReservation(Integer id) throws DAOException {
        return null;
    }

    private PreparedStatement fillStatement(PreparedStatement statement, Reservation reservation) throws SQLException {
        statement.setInt(1, reservation.getUser().getId());
        statement.setInt(2, reservation.getRoomNumber());
        statement.setDate(3, reservation.getDateIn());
        statement.setDate(4, reservation.getDateOut());
        statement.setInt(5, reservation.getDaysCount());

        return statement;
    }
}
