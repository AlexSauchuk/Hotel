package by.hotel.dao.daoimpl;

import by.hotel.bean.*;
import by.hotel.builder.*;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.ReservationRoomDao;
import by.hotel.dao.exception.DAOException;

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
        RoomBuilder roomBuilder = new RoomBuilder();
        UserBuilder userBuilder = new UserBuilder();
        RoomTypeBuilder roomTypeBuilder  = new RoomTypeBuilder();
        ReservationBuilder reservationBuilder = new ReservationBuilder();
        ReservationRoomBuilder reservationRoomBuilder = new ReservationRoomBuilder();
        try {
            connection = getConnection();
            statement = connection.prepareStatement(GET_ALL_RESERVATION_ROOMS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Reservation reservation = reservationBuilder.id(resultSet.getInt("id_reservation"))
                                .dateIn(resultSet.getDate("date-in"))
                                .dateOut(resultSet.getDate("date-out"))
                                .user(userBuilder.id(resultSet.getInt("id_user"))
                                        .passportNumber(resultSet.getString("passport_number"))
                                        .name(resultSet.getString("name"))
                                        .surname(resultSet.getString("surname"))
                                        .sex(resultSet.getString("sex"))
                                        .mobilePhone(resultSet.getString("mobile_phone"))
                                        .build())
                                .build();
                Room room = roomBuilder.id(resultSet.getInt("id_room"))
                                .roomType(roomTypeBuilder.id(resultSet.getInt("id_room_type"))
                                        .roomsCount(resultSet.getInt("rooms_count"))
                                        .bedsCount(resultSet.getInt("beds_count"))
                                        .costPerDay(resultSet.getInt("cost_per_day"))
                                        .additionalInfo(resultSet.getString("additional_info"))
                                        .build())
                                .floor(resultSet.getInt("floor"))
                                .phone(resultSet.getString("phone"))
                                .build();

                reservationRooms.add(reservationRoomBuilder.reservation(reservation)
                                        .room(room)
                                        .build());
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
            statement = connection.prepareStatement(REMOVE_RESERVATION_ROOM);
            statement.setInt(1, reservationRoom.getReservation().getId());
            statement.setInt(2, reservationRoom.getRoom().getId());
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
