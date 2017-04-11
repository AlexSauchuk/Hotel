package by.hotel.dao.daoimpl;


import by.hotel.bean.*;
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
                reservations.add(fillReservation(resultSet));
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
        statement.setString(1, reservation.getUser().getPassword());
        statement.setString(1, reservation.getUser().getMobilePhone());
        statement.setString(1, reservation.getUser().getName());
        statement.setString(1, reservation.getUser().getPassportNumber());
        statement.setString(1, reservation.getUser().getLogin());
        statement.setString(1, reservation.getUser().getSex());
        statement.setString(1, reservation.getUser().getSurname());
        statement.setInt(2, reservation.getRoom().getId());
        statement.setString(2, reservation.getRoom().getPhone());
        statement.setInt(2, reservation.getRoom().getFloor());
        statement.setInt(2, reservation.getRoom().getRoomType().getId());
        statement.setString(2, reservation.getRoom().getRoomType().getAdditionalInfo());
        statement.setFloat(2, reservation.getRoom().getRoomType().getCostPerDay());
        statement.setInt(2, reservation.getRoom().getRoomType().getBedsCount());
        statement.setInt(2, reservation.getRoom().getRoomType().getRoomsCount());
        statement.setDate(3, reservation.getDateIn());
        statement.setDate(4, reservation.getDateOut());
        statement.setInt(5, reservation.getDaysCount());

        return statement;
    }

    private Reservation fillReservation(ResultSet resultSet) throws SQLException {
        Reservation reservation = new Reservation();
        User user = new User();
        user.setName(resultSet.getString("name"));
        user.setSurname(resultSet.getString("surname"));
        user.setMobilePhone(resultSet.getString("mobilePhone"));
        user.setPassportNumber(resultSet.getString("passportNumber"));
        user.setSex(resultSet.getString("sex"));
        reservation.setUser(user);
        reservation.setDateIn(resultSet.getDate("date-in"));
        reservation.setDateOut(resultSet.getDate("date-out"));
        reservation.setDaysCount(resultSet.getInt("days_count"));

        Room room = new Room();
        RoomType roomType = new RoomType(resultSet.getInt("room_type.id"),
                resultSet.getInt("rooms_count"),
                resultSet.getInt("beds_count"),
                resultSet.getInt("cost_per_day"),
                resultSet.getString("additional_info"));
        room.setId(resultSet.getInt("id"));
        room.setRoomType(roomType);
        room.setFloor(resultSet.getInt("floor"));
        room.setPhone(resultSet.getString("phone"));

        reservation.setRoom(room);

        return reservation;
    }
}
