package by.hotel.dao.impl;

import by.hotel.bean.Room;
import by.hotel.bean.RoomType;
import by.hotel.builder.RoomBuilder;
import by.hotel.builder.RoomTypeBuilder;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.RoomTypeDao;
import by.hotel.dao.exception.DAOException;
import by.hotel.util.ErrorStringBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.hotel.dao.constants.Constants.*;

public class RoomTypeDaoImpl extends AbstractDao implements RoomTypeDao {
    public List<String> getRoomTypeHeaders(Connection connection) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<String> headers = new ArrayList<String>();
        StringBuilder stringBuilder = new StringBuilder();
        try {
            statement = connection.prepareStatement(GET_ALL_ROOM_TYPES_HEADERS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                stringBuilder.append(resultSet.getInt("id")+" rooms count: ");
                stringBuilder.append(resultSet.getString("roomsCount"));
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

    public List<RoomType> getRoomTypes(Connection connection) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<RoomType> roomTypes = new ArrayList<>();
        RoomTypeBuilder roomTypeBuilder  = new RoomTypeBuilder();
        try {
            statement = connection.prepareStatement(GET_ALL_ROOM_TYPES);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                 roomTypes.add(fillRoomType(resultSet,roomTypeBuilder));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, resultSet);
        }
        return roomTypes;
    }

    public void addRoomType(RoomType roomType,Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(ADD_ROOM_TYPE);
            statement = fillStatement(statement, roomType);
            statement.execute();
        } catch (SQLException | NullPointerException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
    }

    public void removeRoomType(RoomType roomType,Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(REMOVE_ROOM_TYPE);
            statement.setInt(1, roomType.getId());
            statement.execute();
        }catch (SQLIntegrityConstraintViolationException e){
            throw new DAOException(buildMessage(roomType, e.getMessage()) ,e);
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
    }

    public void updateRoomType(RoomType roomType,Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(UPDATE_ROOM_TYPE);
            statement = fillStatement(statement, roomType);
            statement.setInt(7, roomType.getId());
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
    }

    @Override
    public RoomType getLastInsertedRoomType(Connection connection) throws DAOException {
        PreparedStatement statement = null;
        RoomType roomType = null;
        ResultSet resultSet;
        RoomTypeBuilder roomTypeBuilder = new RoomTypeBuilder();
        try {
            statement = connection.prepareStatement(GET_LAST_INSERTED_ROOM_TYPE);
            // statement.setString(1,room_type");
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                roomType = fillRoomType(resultSet, roomTypeBuilder);
            }
        } catch (SQLException | NullPointerException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
        return roomType;
    }

    private RoomType fillRoomType(ResultSet resultSet, RoomTypeBuilder roomTypeBuilder) throws SQLException {
        return roomTypeBuilder.id(resultSet.getInt("id"))
                .roomsCount(resultSet.getInt("roomsCount"))
                .bedsCount(resultSet.getInt("bedsCount"))
                .costPerDay(resultSet.getInt("costPerDay"))
                .additionalInfo(resultSet.getString("additionalInfo"))
                .bathroomsCount(resultSet.getInt("bathroomsCount"))
                .size(resultSet.getInt("size"))
                .build();
    }

    private PreparedStatement fillStatement(PreparedStatement statement, RoomType roomType) throws SQLException {
        statement.setInt(1, roomType.getRoomsCount());
        statement.setInt(2, roomType.getBedsCount());
        statement.setFloat(3, roomType.getCostPerDay());
        statement.setString(4, roomType.getAdditionalInfo());
        statement.setInt(5, roomType.getBathroomsCount());
        statement.setInt(6, roomType.getSize());
        return statement;
    }

    private String buildMessage(RoomType roomType, String errorMessage){
        Map<String,String> idNames = new HashMap<String, String>();
        idNames.put("id",Integer.toString(roomType.getId()));
        return ErrorStringBuilder.buildDeleteErrorString(idNames,errorMessage);
    }
}
