package by.hotel.dao.daoimpl;

import by.hotel.bean.Room;
import by.hotel.builder.RoomBuilder;
import by.hotel.builder.RoomTypeBuilder;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.RoomDao;
import by.hotel.dao.constants.Constants;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.hotel.dao.constants.Constants.*;

public class RoomDaoImpl extends AbstractDao implements RoomDao {
    public List<Room> getRooms(Connection connection) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Room> rooms = new ArrayList<Room>();
        RoomBuilder roomBuilder = new RoomBuilder();
        RoomTypeBuilder roomTypeBuilder  = new RoomTypeBuilder();
        try {
            statement = connection.prepareStatement(Constants.GET_ALL_ROOMS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                rooms.add(roomBuilder.id(resultSet.getInt("id"))
                            .roomType(roomTypeBuilder.id(resultSet.getInt("id_room_type"))
                                    .roomsCount(resultSet.getInt("rooms_count"))
                                    .bedsCount(resultSet.getInt("beds_count"))
                                    .costPerDay(resultSet.getInt("cost_per_day"))
                                    .additionalInfo(resultSet.getString("additional_info")).build())
                            .floor(resultSet.getInt("floor"))
                            .phone(resultSet.getString("phone"))
                            .phone(resultSet.getString("path"))
                            .build());
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
        } catch (SQLException e) {
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
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
    }

    private PreparedStatement fillStatement(PreparedStatement statement, Room room) throws SQLException {
        statement.setInt(1, room.getRoomType().getId());
        statement.setInt(2, room.getFloor());
        statement.setString(3, room.getPhone());
        statement.setString(4, room.getPath());
        return statement;
    }
}
