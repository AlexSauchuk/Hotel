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

/**
 * Created by 1 on 06.04.2017.
 */
public class ReservationRoomImpl extends AbstractDao implements ReservationRoomDao {
    private static final Logger logger = LogManager.getLogger(ReservationRoomImpl.class.getName());

    public List<ReservationRoom> getReservationRooms() throws DAOException {
        Connection connection;
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

                reservationRoom.setReservation(reservation);

                Room room = new Room();
                // ТО, что снизу, не уверен!!!!!!!!!!!!!!!!!!!!
                RoomType roomType = new RoomType(resultSet.getInt("room_type.id"),
                        resultSet.getInt("rooms_count"),
                        resultSet.getInt("beds_count"),
                        resultSet.getInt("cost_per_day"),
                        resultSet.getString("additional_info"));
                room.setId(resultSet.getInt("id"));
                room.setRoomType(roomType);
                room.setFloor(resultSet.getInt("floor"));
                room.setPhone(resultSet.getString("phone"));

                reservationRoom.setRoom(room);
                reservationRooms.add(reservationRoom);
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
        return reservationRooms;
    }

    public void addReservationRoom(ReservationRoom reservationRoom) throws DAOException {
        Connection connection;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(ADD_RESERVATION_ROOM);
            statement = fillStatement(statement, reservationRoom);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            finalize(statement);
        }
    }

    public void removeReservationRoom(ReservationRoom reservationRoom) throws DAOException {
        Connection connection;
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
            finalize(statement);
        }
    }

    public void updateReservationRoom(ReservationRoom reservationRoom) throws DAOException {
        Connection connection;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(UPDATE_RESERVATION_ROOM);
            statement = fillStatement(statement, reservationRoom);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            finalize(statement);
        }
    }

    private PreparedStatement fillStatement(PreparedStatement statement, ReservationRoom reservationRoom) throws SQLException {
        statement.setInt(1, reservationRoom.getRoom().getId());
        statement.setInt(2, reservationRoom.getReservation().getId());

        return statement;
    }
}
