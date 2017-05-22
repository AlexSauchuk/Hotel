package by.hotel.dao.impl;

import by.hotel.bean.ParkingSpace;
import by.hotel.builder.ParkingSpaceBuilder;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.ParkingSpaceDao;
import by.hotel.dao.exception.DAOException;
import by.hotel.util.ErrorStringBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.hotel.dao.constants.Constants.*;

public class ParkingSpaceDaoImpl extends AbstractDao implements ParkingSpaceDao {
    public List<String> getParkingSpaceHeaders(Connection connection) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<String> headers = new ArrayList<String>();
        StringBuilder stringBuilder = new StringBuilder();
        try {
            statement = connection.prepareStatement(GET_ALL_PARKING_SPACES_HEADERS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                stringBuilder.append(resultSet.getInt("id")+" ");
                stringBuilder.append("level " + resultSet.getString("level"));
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

    public List<ParkingSpace> getParkingSpaces(Connection connection) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<ParkingSpace> parkingSpaces = new ArrayList<>();
        ParkingSpaceBuilder parkingSpaceBuilder = new ParkingSpaceBuilder();
        try {
            statement = connection.prepareStatement(GET_ALL_PARKING_SPACES);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                parkingSpaces.add(fillParkingSpace(resultSet,parkingSpaceBuilder));
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
        } catch (SQLException | NullPointerException e) {
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
        }catch (SQLIntegrityConstraintViolationException e){
            throw new DAOException(buildMessage(parkingSpace, e.getMessage()),e);
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
            statement.setInt(3, parkingSpace.getId());
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
    }

    @Override
    public ParkingSpace getLastInsertedParkingSpace(Connection connection) throws DAOException {
        PreparedStatement statement = null;
        ParkingSpace parkingSpace = null;
        ResultSet resultSet;
        ParkingSpaceBuilder parkingSpaceBuilder = new ParkingSpaceBuilder();
        try {
            statement = connection.prepareStatement(GET_LAST_INSERTED_PARKING_SPACE);
            // statement.setString(1,"parking_space");
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                parkingSpace = fillParkingSpace(resultSet,parkingSpaceBuilder);
            }
        } catch (SQLException | NullPointerException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
        return parkingSpace;
    }

    private PreparedStatement fillStatement(PreparedStatement statement, ParkingSpace parkingSpace) throws SQLException {
        statement.setInt(1, parkingSpace.getLevel());
        statement.setByte(2, parkingSpace.getReserved());
        return statement;
    }

    private ParkingSpace fillParkingSpace(ResultSet resultSet, ParkingSpaceBuilder parkingSpaceBuilder) throws SQLException {
        return parkingSpaceBuilder.id(resultSet.getInt("id"))
                .level(resultSet.getInt("level"))
                .reserved(resultSet.getByte("reserved"))
                .build();
    }

    private String buildMessage(ParkingSpace parkingSpace, String errorMessage){
        Map<String,String> idNames = new HashMap<String, String>();
        idNames.put("id",Integer.toString(parkingSpace.getId()));
        return ErrorStringBuilder.buildDeleteErrorString(idNames,errorMessage);
    }
}