package by.hotel.dao.daoimpl;

import by.hotel.bean.*;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.ReservationRoomDao;
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

public class ReservationRoomDaoImpl extends AbstractDao implements ReservationRoomDao {
    public List<ReservationRoom> getReservationRooms() throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<ReservationRoom> reservationRooms = new ArrayList<ReservationRoom>();
        try {
            connection = getConnection();
            statement = connection.prepareStatement(Constants.GET_ALL_RESERVATION_ROOMS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ReservationRoom reservationRoom = new ReservationRoom();
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

                reservationRoom.setReservation(reservation);

                Room room = new Room();
                RoomType roomType = new RoomType(resultSet.getInt("id_room_type"),
                        resultSet.getInt("rooms_count"),
                        resultSet.getInt("beds_count"),
                        resultSet.getInt("cost_per_day"),
                        resultSet.getString("additional_info"));
                room.setId(resultSet.getInt("id_room"));
                room.setRoomType(roomType);
                room.setFloor(resultSet.getInt("floor"));
                room.setPhone(resultSet.getString("phone"));

                reservationRoom.setRoom(room);
                reservationRooms.add(reservationRoom);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeConnection(connection, statement, resultSet);
        }
        return reservationRooms;
    }

    public void addReservationRoom(ReservationRoom reservationRoom) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(ADD_RESERVATION_ROOM);
            statement = fillStatement(statement, reservationRoom);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeConnection(connection, statement, null);
        }
    }

    public void removeReservationRoom(ReservationRoom reservationRoom) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement.setInt(1, reservationRoom.getReservation().getId());
            statement.setInt(2, reservationRoom.getRoom().getId());
            statement = connection.prepareStatement(REMOVE_RESERVATION_ROOM);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeConnection(connection, statement, null);
        }
    }

    public void updateReservationRoom(ReservationRoom reservationRoom) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(UPDATE_RESERVATION_ROOM);
            statement = fillStatement(statement, reservationRoom);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeConnection(connection, statement, null);
        }
    }

    private PreparedStatement fillStatement(PreparedStatement statement, ReservationRoom reservationRoom) throws SQLException {
        statement.setInt(1, reservationRoom.getRoom().getId());
        statement.setInt(2, reservationRoom.getReservation().getId());

        return statement;
    }
}
