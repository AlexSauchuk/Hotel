package by.hotel.dao.impl;

import by.hotel.bean.*;
import by.hotel.builder.*;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.ReservationRoomDao;
import by.hotel.dao.exception.DAOException;
import by.hotel.util.ErrorStringBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.hotel.dao.constants.Constants.*;

public class ReservationRoomDaoImpl extends AbstractDao implements ReservationRoomDao {
    public List<ReservationRoom> getReservationRooms(Connection connection) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<ReservationRoom> reservationRooms = new ArrayList<ReservationRoom>();
        RoomBuilder roomBuilder = new RoomBuilder();
        UserBuilder userBuilder = new UserBuilder();
        RoomTypeBuilder roomTypeBuilder  = new RoomTypeBuilder();
        DiscountBuilder discountBuilder = new DiscountBuilder();
        ReservationBuilder reservationBuilder = new ReservationBuilder();
        ReservationRoomBuilder reservationRoomBuilder = new ReservationRoomBuilder();
        try {
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
                                        .mobilePhone(resultSet.getString("mobile_phone"))
                                        .build())
                                .costAdditionalServices(resultSet.getInt("cost_additional_services"))
                                .discount(discountBuilder.id(resultSet.getInt("discount_id"))
                                        .name(resultSet.getString("discount_name"))
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
            closeStatement(statement, resultSet);
        }
        return reservationRooms;
    }

    public void addReservationRoom(ReservationRoom reservationRoom,Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(ADD_RESERVATION_ROOM);
            statement = fillStatement(statement, reservationRoom);
            statement.execute();
        }catch (SQLIntegrityConstraintViolationException e){
            throw new DAOException(buildMessage(reservationRoom),e);
        } catch (SQLException | NullPointerException e) {
            throw new DAOException(buildMessage(reservationRoom),e);
        }finally {
            closeStatement(statement, null);
        }
    }

    public void removeReservationRoom(ReservationRoom reservationRoom,Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(REMOVE_RESERVATION_ROOM);
            statement = fillStatement(statement, reservationRoom);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
    }

    public void updateReservationRoom(ReservationRoom reservationRoom,Connection connection) throws DAOException {
        throw new UnsupportedOperationException("Unsupported operation!");
    }

    @Override
    public ReservationRoom getLastInsertedReservationRoom(Connection connection) throws DAOException {
        PreparedStatement statement = null;
        ReservationRoom reservationRoom = null;
        ResultSet resultSet;
        ReservationRoomBuilder reservationRoomBuilder = new ReservationRoomBuilder();
        try {
            statement = connection.prepareStatement(GET_LAST_INSERTED_RESERVATION_ROOM);
            // statement.setString(1,"reservation_room");
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                reservationRoom = fillReservationRoom(resultSet, reservationRoomBuilder);
            }
        } catch (SQLException | NullPointerException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
        return reservationRoom;
    }

    private ReservationRoom fillReservationRoom(ResultSet resultSet, ReservationRoomBuilder reservationRoomBuilder) throws SQLException {
        RoomBuilder roomBuilder = new RoomBuilder();
        UserBuilder userBuilder = new UserBuilder();
        RoomTypeBuilder roomTypeBuilder  = new RoomTypeBuilder();
        DiscountBuilder discountBuilder = new DiscountBuilder();
        ReservationBuilder reservationBuilder = new ReservationBuilder();
        Reservation reservation = reservationBuilder.id(resultSet.getInt("id_reservation"))
                .dateIn(resultSet.getDate("date-in"))
                .dateOut(resultSet.getDate("date-out"))
                .user(userBuilder.id(resultSet.getInt("id_user"))
                        .passportNumber(resultSet.getString("passport_number"))
                        .name(resultSet.getString("name"))
                        .surname(resultSet.getString("surname"))
                        .mobilePhone(resultSet.getString("mobile_phone"))
                        .build())
                .costAdditionalServices(resultSet.getInt("cost_additional_services"))
                .discount(discountBuilder.id(resultSet.getInt("discount_id"))
                        .name(resultSet.getString("discount_name"))
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

        return reservationRoomBuilder.reservation(reservation)
                .room(room)
                .build();
    }

    private PreparedStatement fillStatement(PreparedStatement statement, ReservationRoom reservationRoom) throws SQLException {
        statement.setInt(1, reservationRoom.getRoom().getId());
        statement.setInt(2, reservationRoom.getReservation().getId());

        return statement;
    }

    private String buildMessage(ReservationRoom reservationRoom){
        Map<String,String> idNames = new HashMap<String, String>();
        idNames.put("reservation",Integer.toString(reservationRoom.getReservation().getId()));
        idNames.put("room",Integer.toString(reservationRoom.getRoom().getId()));
        return ErrorStringBuilder.buildAddErrorString(idNames);
    }

}
