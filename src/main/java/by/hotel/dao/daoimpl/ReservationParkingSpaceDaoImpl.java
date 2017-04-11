package by.hotel.dao.daoimpl;

import by.hotel.bean.*;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.ReservationParkingSpaceDao;
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

/**
 * Created by 1 on 06.04.2017.
 */
public class ReservationParkingSpaceDaoImpl extends AbstractDao implements ReservationParkingSpaceDao {
    private static final Logger logger = LogManager.getLogger(ReservationDaoImpl.class.getName());

    public List<ReservationParkingSpace> getReservationParkingSpaces() throws DAOException {
        Connection connection;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<ReservationParkingSpace> reservationParkingSpaces = new ArrayList<ReservationParkingSpace>();
        try {
            connection = getConnection();
            statement = connection.prepareStatement(Constants.GET_ALL_RESERVATION_PARKING_SPACES);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                reservationParkingSpaces.add(fillReservationParkingSpace(resultSet));
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
        return reservationParkingSpaces;
    }

    public void addReservationParkingSpace(ReservationParkingSpace reservationParkingSpace) throws DAOException {
        Connection connection;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(ADD_RESERVATION_PARKING_SPACE);
            statement = fillStatement(statement, reservationParkingSpace);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            finalize(statement);
        }
    }

    public void removeReservationParkingSpace(ReservationParkingSpace reservationParkingSpace) throws DAOException {
        Connection connection;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement.setInt(1, reservationParkingSpace.getReservation().getId());
            statement.setInt(2, reservationParkingSpace.getParkingSpace().getId());
            statement = connection.prepareStatement(REMOVE_RESERVATION_PARKING_SPACE);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            finalize(statement);
        }
    }

    public void updateReservationParkingSpace(ReservationParkingSpace reservationParkingSpace) throws DAOException {
        Connection connection;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(UPDATE_RESERVATION_PARKING_SPACE);
            statement = fillStatement(statement, reservationParkingSpace);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            finalize(statement);
        }
    }
    private PreparedStatement fillStatement(PreparedStatement statement, ReservationParkingSpace reservationParkingSpace) throws SQLException {
        statement.setInt(1, reservationParkingSpace.getParkingSpace().getId());
        statement.setInt(2, reservationParkingSpace.getReservation().getId());

        return statement;
    }

    private ReservationParkingSpace fillReservationParkingSpace(ResultSet resultSet) throws SQLException {
        ReservationParkingSpace reservationParkingSpace = new ReservationParkingSpace();
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



        ParkingSpace parkingSpace = new ParkingSpace();
        parkingSpace.setId(resultSet.getInt("id"));
        parkingSpace.setId(resultSet.getInt("level"));
        parkingSpace.setReserved(resultSet.getBoolean("is_reserved"));

        reservationParkingSpace.setParkingSpace(parkingSpace);

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

        reservationParkingSpace.setReservation(reservation);

        return reservationParkingSpace;
    }

}
