package by.hotel.dao.daoimpl;

import by.hotel.bean.ParkingSpace;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.ParkingSpaceDao;
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

public class ParkingSpaceDaoImpl extends AbstractDao implements ParkingSpaceDao {
    public List<Integer> getId() throws DAOException {
        return null;
    }

    public List<ParkingSpace> getParkingSpaces() throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<ParkingSpace> parkingSpaces = new ArrayList<ParkingSpace>();
        try {
            connection = getConnection();
            statement = connection.prepareStatement(Constants.GET_ALL_PARKING_SPACES);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                parkingSpaces.add(fillParkingSpace(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeConnection(connection, statement, resultSet);
        }
        return parkingSpaces;
    }

    public void addParkingSpace(ParkingSpace parkingSpace) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(ADD_PARKING_SPACE);
            statement = fillStatement(statement, parkingSpace);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeConnection(connection, statement, null);
        }
    }

    public void removeParkingSpace(ParkingSpace parkingSpace) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(REMOVE_PARKING_SPACE);
            statement.setInt(1, parkingSpace.getId());
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeConnection(connection, statement, null);
        }
    }

    public void updateParkingSpace(ParkingSpace parkingSpace) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(UPDATE_PARKING_SPACE);
            statement = fillStatement(statement, parkingSpace);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeConnection(connection, statement, null);
        }
    }

    public ParkingSpace getParkingSpace(Integer id) throws DAOException {
        return null;
    }

    private PreparedStatement fillStatement(PreparedStatement statement, ParkingSpace parkingSpace) throws SQLException {
        statement.setInt(1, parkingSpace.getId());
        statement.setInt(2, parkingSpace.getLevel());
        statement.setBoolean(3, parkingSpace.isReserved());
        return statement;
    }

    private ParkingSpace fillParkingSpace(ResultSet resultSet) throws SQLException {
        ParkingSpace parkingSpace = new ParkingSpace();
        parkingSpace.setId(resultSet.getInt("id"));
        parkingSpace.setId(resultSet.getInt("level"));
        parkingSpace.setReserved(resultSet.getBoolean("is_reserved"));

        return parkingSpace;
    }
}