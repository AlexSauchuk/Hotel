package by.hotel.dao.daoimpl;

import by.hotel.bean.ParkingSpace;
import by.hotel.builder.ParkingSpaceBuilder;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.ParkingSpaceDao;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.hotel.dao.constants.Constants.*;

public class ParkingSpaceDaoImpl extends AbstractDao implements ParkingSpaceDao {
    public List<ParkingSpace> getParkingSpaces(Connection connection) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<ParkingSpace> parkingSpaces = new ArrayList<ParkingSpace>();
        ParkingSpaceBuilder parkingSpaceBuilder = new ParkingSpaceBuilder();
        try {
            statement = connection.prepareStatement(GET_ALL_PARKING_SPACES);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                parkingSpaces.add(parkingSpaceBuilder.id(resultSet.getInt("id"))
                                    .level(resultSet.getInt("level"))
                                    .reserved(resultSet.getByte("is_reserved"))
                                    .build());
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, resultSet);
        }
        return parkingSpaces;
    }

    public void addParkingSpace(ParkingSpace parkingSpace,Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(ADD_PARKING_SPACE);
            statement = fillStatement(statement, parkingSpace);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
    }

    public void removeParkingSpace(ParkingSpace parkingSpace,Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(REMOVE_PARKING_SPACE);
            statement.setInt(1, parkingSpace.getId());
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
    }

    public void updateParkingSpace(ParkingSpace parkingSpace,Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(UPDATE_PARKING_SPACE);
            statement = fillStatement(statement, parkingSpace);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
    }

    public ParkingSpace getParkingSpace(Integer id,Connection connection) throws DAOException {
        return null;
    }

    private PreparedStatement fillStatement(PreparedStatement statement, ParkingSpace parkingSpace) throws SQLException {
        statement.setInt(1, parkingSpace.getId());
        statement.setInt(2, parkingSpace.getLevel());
        statement.setByte(3, parkingSpace.getReserved());
        return statement;
    }
}