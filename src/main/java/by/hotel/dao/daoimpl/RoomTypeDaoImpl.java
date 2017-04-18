package by.hotel.dao.daoimpl;

import by.hotel.bean.RoomType;
import by.hotel.builder.RoomTypeBuilder;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.RoomTypeDao;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.hotel.dao.constants.Constants.*;

public class RoomTypeDaoImpl extends AbstractDao implements RoomTypeDao {
    public List<RoomType> getRoomTypes(Connection connection) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<RoomType> roomTypes = new ArrayList<RoomType>();
        RoomTypeBuilder roomTypeBuilder  = new RoomTypeBuilder();
        try {
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
        } catch (SQLException e) {
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
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
    }

    private PreparedStatement fillStatement(PreparedStatement statement, RoomType roomType) throws SQLException {
        statement.setInt(1, roomType.getId());
        statement.setInt(2, roomType.getRoomsCount());
        statement.setInt(3, roomType.getBedsCount());
        statement.setFloat(4, roomType.getCostPerDay());
        statement.setString(5, roomType.getAdditionalInfo());
        return statement;
    }
}
