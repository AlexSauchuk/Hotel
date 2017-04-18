package by.hotel.dao.daoimpl;

import by.hotel.bean.Room;
import by.hotel.bean.RoomType;
import by.hotel.builder.RoomTypeBuilder;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.RoomTypeDao;
import by.hotel.dao.constants.Constants;
import by.hotel.dao.exception.DAOException;
import by.hotel.util.ErrorStringBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.hotel.dao.constants.Constants.*;

public class RoomTypeDaoImpl extends AbstractDao implements RoomTypeDao {
    public List<Integer> getId() throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Integer> arrayId = new ArrayList<Integer>();
        try {
            connection = getConnection();
            statement = connection.prepareStatement(Constants.GET_ALL_ID_ROOM_TYPES);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                arrayId.add(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeConnection(connection, statement, resultSet);
        }
        return arrayId;
    }

    public List<RoomType> getRoomTypes() throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<RoomType> roomTypes = new ArrayList<RoomType>();
        RoomTypeBuilder roomTypeBuilder  = new RoomTypeBuilder();
        try {
            connection = getConnection();
            statement = connection.prepareStatement(GET_ALL_ROOM_TYPES);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                 roomTypes.add(roomTypeBuilder.id(resultSet.getInt("id"))
                                .roomsCount(resultSet.getInt("rooms_count"))
                                .bedsCount(resultSet.getInt("beds_count"))
                                .costPerDay(resultSet.getInt("cost_per_day"))
                                .additionalInfo(resultSet.getString("additional_info"))
                                .build());
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeConnection(connection, statement, resultSet);
        }
        return roomTypes;
    }

    public void addRoomType(RoomType roomType) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(ADD_ROOM_TYPE);
            statement = fillStatement(statement, roomType);
            statement.setInt(5, roomType.getId());
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeConnection(connection, statement, null);
        }
    }

    public void removeRoomType(RoomType roomType) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(REMOVE_ROOM_TYPE);
            statement.setInt(1, roomType.getId());
            statement.execute();
        }catch (SQLIntegrityConstraintViolationException e){
            throw new DAOException(buildMessage(roomType, e.getMessage()) ,e);
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeConnection(connection, statement, null);
        }
    }

    public void updateRoomType(RoomType roomType) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(UPDATE_ROOM_TYPE);
            statement = fillStatement(statement, roomType);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeConnection(connection, statement, null);
        }
    }

    private PreparedStatement fillStatement(PreparedStatement statement, RoomType roomType) throws SQLException {
        statement.setInt(1, roomType.getRoomsCount());
        statement.setInt(2, roomType.getBedsCount());
        statement.setFloat(3, roomType.getCostPerDay());
        statement.setString(4, roomType.getAdditionalInfo());
        return statement;
    }

    private String buildMessage(RoomType roomType, String errorMessage){
        Map<String,String> idNames = new HashMap<String, String>();
        idNames.put("id",Integer.toString(roomType.getId()));
        return ErrorStringBuilder.buildErrorString(idNames,errorMessage);
    }
}
