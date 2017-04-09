package by.hotel.dao.daoimpl;

import by.hotel.bean.Room;
import by.hotel.bean.RoomType;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.RoomDao;
import by.hotel.dao.RoomTypeDao;
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
 * Created by 1 on 04.04.2017.
 */
public class RoomTypeDaoImpl extends AbstractDao implements RoomTypeDao {
    private static final Logger logger = LogManager.getLogger(RoomTypeDaoImpl.class.getName());

    public List<RoomType> getRoomTypes() throws DAOException {
        Connection connection;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<RoomType> roomTypes = new ArrayList<RoomType>();
        try {
            connection = getConnection();
            statement = connection.prepareStatement(Constants.GET_ALL_ROOM_TYPES);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                RoomType roomType = new RoomType();
                roomType.setId(resultSet.getInt("id"));
                roomType.setRoomsCount(resultSet.getInt("rooms_count"));
                roomType.setBedsCount(resultSet.getInt("beds_count"));
                roomType.setCostPerDay(resultSet.getInt("cost_per_day"));
                roomType.setAdditionalInfo(resultSet.getString("additional_info"));
                roomTypes.add(roomType);
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
        return roomTypes;
    }

    public void addRoomType(RoomType roomType) throws DAOException {
        Connection connection;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(ADD_ROOM_TYPE);
            statement = fillStatement(statement, roomType);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            finalize(statement);
        }
    }

    public void removeRoomType(RoomType roomType) throws DAOException {
        Connection connection;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement.setInt(1, roomType.getId());
            statement = connection.prepareStatement(REMOVE_ROOM_TYPE);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            finalize(statement);
        }
    }

    public void updateRoomType(RoomType roomType) throws DAOException {
        Connection connection;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(UPDATE_ROOM_TYPE);
            statement = fillStatement(statement, roomType);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            finalize(statement);
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
