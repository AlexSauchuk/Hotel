package by.hotel.dao.daoimpl;

import by.hotel.bean.ParkingSpace;
import by.hotel.bean.Reservation;
import by.hotel.bean.ReservationParkingSpace;
import by.hotel.bean.User;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.ReservationParkingSpaceDao;
import by.hotel.dao.constants.Constants;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.hotel.dao.constants.Constants.*;

public class ReservationParkingSpaceDaoImpl extends AbstractDao implements ReservationParkingSpaceDao {
    public List<Integer> getId() throws DAOException {
        return null;
    }

    public List<ReservationParkingSpace> getReservationParkingSpaces() throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<ReservationParkingSpace> reservationParkingSpaces = new ArrayList<ReservationParkingSpace>();
        try {
            connection = getConnection();
            statement = connection.prepareStatement(Constants.GET_ALL_RESERVATION_PARKING_SPACES);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ReservationParkingSpace reservationParkingSpace = new ReservationParkingSpace();
                Reservation reservation = new Reservation();
                User user = new User();
                user.setId(resultSet.getInt("id_user"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setMobilePhone(resultSet.getString("mobile_phone"));
                user.setPassportNumber(resultSet.getString("passport_number"));
                user.setSex(resultSet.getString("sex"));
                reservation.setUser(user);
                reservation.setId(resultSet.getInt("id_reservation"));
                reservation.setDateIn(resultSet.getDate("date-in"));
                reservation.setDateOut(resultSet.getDate("date-out"));

                reservationParkingSpace.setReservation(reservation);

                ParkingSpace parkingSpace = new ParkingSpace();
                parkingSpace.setId(resultSet.getInt("id_parking_space"));
                parkingSpace.setId(resultSet.getInt("level"));
                parkingSpace.setReserved(resultSet.getBoolean("is_reserved"));

                reservationParkingSpace.setParkingSpace(parkingSpace);

                reservationParkingSpaces.add(reservationParkingSpace);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeConnection(connection, statement, resultSet);
        }
        return reservationParkingSpaces;
    }

    public void addReservationParkingSpace(ReservationParkingSpace reservationParkingSpace) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(ADD_RESERVATION_PARKING_SPACE);
            statement = fillStatement(statement, reservationParkingSpace);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeConnection(connection, statement, null);
        }
    }

    public void removeReservationParkingSpace(ReservationParkingSpace reservationParkingSpace) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(REMOVE_RESERVATION_PARKING_SPACE);
            statement = fillStatement(statement, reservationParkingSpace);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeConnection(connection, statement, null);
        }
    }

    public void updateReservationParkingSpace(ReservationParkingSpace reservationParkingSpace) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(UPDATE_RESERVATION_PARKING_SPACE);
            statement = fillStatement(statement, reservationParkingSpace);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeConnection(connection, statement, null);
        }
    }
    private PreparedStatement fillStatement(PreparedStatement statement, ReservationParkingSpace reservationParkingSpace) throws SQLException {
        statement.setInt(1, reservationParkingSpace.getParkingSpace().getId());
        statement.setInt(2, reservationParkingSpace.getReservation().getId());
        return statement;
    }
}
