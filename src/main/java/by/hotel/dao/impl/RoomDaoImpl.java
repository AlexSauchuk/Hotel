package by.hotel.dao.impl;

import by.hotel.bean.Room;
import by.hotel.builder.RoomBuilder;
import by.hotel.builder.RoomTypeBuilder;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.RoomDao;
import by.hotel.dao.exception.DAOException;
import by.hotel.util.ErrorStringBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.hotel.dao.constants.Constants.*;

public class RoomDaoImpl extends AbstractDao implements RoomDao {
    public List<String> getRoomHeaders(Connection connection) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<String> headers = new ArrayList<String>();
        StringBuilder stringBuilder = new StringBuilder();
        try {
            statement = connection.prepareStatement(GET_ALL_ROOMS_HEADERS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                stringBuilder.append(resultSet.getInt("id")+" ");
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

    public List<Room> getRooms(Connection connection) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Room> rooms = new ArrayList<>();
        RoomBuilder roomBuilder = new RoomBuilder();
        try {
            statement = connection.prepareStatement(GET_ALL_ROOMS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                rooms.add(fillRoom(resultSet,roomBuilder));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, resultSet);
        }
        return rooms;
    }

    public void addRoom(Room room,Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(ADD_ROOM);
            statement = fillStatement(statement, room);
            statement.execute();
        } catch (SQLException | NullPointerException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
    }

    public void removeRoom(Room room,Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(REMOVE_ROOM);
            statement.setInt(1, room.getId());
            statement.execute();
        }catch (SQLIntegrityConstraintViolationException e){
            throw new DAOException(buildMessage(room, e.getMessage()) ,e);
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
    }

    public void updateRoom(Room room,Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(UPDATE_ROOM);
            statement = fillStatement(statement, room);
            statement.setInt(6, room.getId());
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
    }

    @Override
    public Room getLastInsertedRoom(Connection connection) throws DAOException {
        PreparedStatement statement = null;
        Room room = null;
        ResultSet resultSet;
        RoomBuilder roomBuilder = new RoomBuilder();
        RoomTypeBuilder roomTypeBuilder  = new RoomTypeBuilder();
        try {
            statement = connection.prepareStatement(GET_LAST_INSERTED_ROOM);
            // statement.setString(1,room");
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                room = roomBuilder.id(resultSet.getInt("id"))
                        .roomType(roomTypeBuilder.id(resultSet.getInt("idRoomType"))
                                .additionalInfo(resultSet.getString("additionalInfo"))
                                .build())
                        .floor(resultSet.getInt("floor"))
                        .phone(resultSet.getString("phone"))
                        .name(resultSet.getString("name"))
                        .build();
            }
        } catch (SQLException | NullPointerException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
        return room;
    }

    private Room fillRoom(ResultSet resultSet, RoomBuilder roomBuilder) throws SQLException {
        RoomTypeBuilder roomTypeBuilder  = new RoomTypeBuilder();
        return roomBuilder.id(resultSet.getInt("id"))
                .roomType(roomTypeBuilder.id(resultSet.getInt("idRoomType"))
                        .roomsCount(resultSet.getInt("roomsCount"))
                        .bedsCount(resultSet.getInt("bedsCount"))
                        .costPerDay(resultSet.getInt("costPerDay"))
                        .additionalInfo(resultSet.getString("additionalInfo"))
                        .bathroomsCount(resultSet.getInt("bathroomsCount"))
                        .size(resultSet.getInt("size")).build())
                .floor(resultSet.getInt("floor"))
                .phone(resultSet.getString("phone"))
                .name(resultSet.getString("name"))
                .path(resultSet.getString("path"))
                .build();
    }

    private PreparedStatement fillStatement(PreparedStatement statement, Room room) throws SQLException {
        statement.setInt(1, room.getRoomType().getId());
        statement.setString(2, room.getName());
        statement.setInt(3, room.getFloor());
        statement.setString(4, room.getPhone());
        statement.setString(5, room.getPath());
        return statement;
    }

    private String buildMessage(Room room, String errorMessage){
        Map<String,String> idNames = new HashMap<String, String>();
        idNames.put("id",Integer.toString(room.getId()));
        return ErrorStringBuilder.buildDeleteErrorString(idNames,errorMessage);
    }
}