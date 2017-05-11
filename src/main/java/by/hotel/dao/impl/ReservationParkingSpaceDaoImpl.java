package by.hotel.dao.impl;

import by.hotel.bean.ReservationParkingSpace;
import by.hotel.bean.Role;
import by.hotel.builder.*;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.ReservationParkingSpaceDao;
import by.hotel.dao.exception.DAOException;
import by.hotel.util.ErrorStringBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.hotel.dao.constants.Constants.*;

public class ReservationParkingSpaceDaoImpl extends AbstractDao implements ReservationParkingSpaceDao {
    public List<ReservationParkingSpace> getReservationParkingSpaces(Connection connection) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<ReservationParkingSpace> reservationParkingSpaces = new ArrayList<>();
        ReservationParkingSpaceBuilder reservationParkingSpaceBuilder = new ReservationParkingSpaceBuilder();
        try {
            statement = connection.prepareStatement(GET_ALL_RESERVATION_PARKING_SPACES);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                reservationParkingSpaces.add(fillReservationParkingSpace(resultSet,reservationParkingSpaceBuilder));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, resultSet);
        }
        return reservationParkingSpaces;
    }

    public void addReservationParkingSpace(ReservationParkingSpace reservationParkingSpace, Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(ADD_RESERVATION_PARKING_SPACE);
            statement = fillStatement(statement, reservationParkingSpace);
            statement.execute();
        }catch (SQLIntegrityConstraintViolationException e){
            throw new DAOException(buildMessage(reservationParkingSpace),e);
        }catch (SQLException | NullPointerException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
    }

    public void removeReservationParkingSpace(ReservationParkingSpace reservationParkingSpace,Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(REMOVE_RESERVATION_PARKING_SPACE);
            statement = fillStatement(statement, reservationParkingSpace);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
    }

    public void updateReservationParkingSpace(ReservationParkingSpace reservationParkingSpace,Connection connection) throws DAOException {
        throw new UnsupportedOperationException("Unsupported operation!");
    }

    @Override
    public ReservationParkingSpace getLastInsertedReservationParkingSpace(Connection connection) throws DAOException {
        PreparedStatement statement = null;
        ReservationParkingSpace reservationParkingSpace = null;
        ResultSet resultSet;
        ReservationParkingSpaceBuilder reservationParkingSpaceBuilder = new ReservationParkingSpaceBuilder();
        try {
            statement = connection.prepareStatement(GET_LAST_INSERTED_RESERVATION_PARKING_SPACE);
            // statement.setString(1,"reservation_parking_space");
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                reservationParkingSpace = fillReservationParkingSpace(resultSet, reservationParkingSpaceBuilder);
            }
        } catch (SQLException | NullPointerException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
        return reservationParkingSpace;
    }

    private ReservationParkingSpace fillReservationParkingSpace(ResultSet resultSet, ReservationParkingSpaceBuilder reservationParkingSpaceBuilder) throws SQLException {
        UserBuilder userBuilder = new UserBuilder();
        DiscountBuilder discountBuilder = new DiscountBuilder();
        ReservationBuilder reservationBuilder = new ReservationBuilder();
        ParkingSpaceBuilder parkingSpaceBuilder = new ParkingSpaceBuilder();
        return reservationParkingSpaceBuilder
                .reservation(reservationBuilder.id(resultSet.getInt("idReservation"))
                        .dateIn(resultSet.getDate("dateIn"))
                        .dateOut(resultSet.getDate("dateOut"))
                        .user(userBuilder.id(resultSet.getInt("idUser"))
                                .passportNumber(resultSet.getString("passportNumber"))
                                .name(resultSet.getString("name"))
                                .surname(resultSet.getString("surname"))
                                .mobilePhone(resultSet.getString("mobilePhone"))
                                .build())
                        .costAdditionalServices(resultSet.getInt("costAdditionalServices"))
                        .discount(discountBuilder.id(resultSet.getInt("idDiscount"))
                                .name(resultSet.getString("discountName"))
                                .build())
                        .build())
                .parkingSpace(parkingSpaceBuilder.id(resultSet.getInt("idParkingSpace"))
                        .level(resultSet.getInt("level"))
                        .reserved(resultSet.getByte("reserved"))
                        .build())
                .build();
    }

    private PreparedStatement fillStatement(PreparedStatement statement, ReservationParkingSpace reservationParkingSpace) throws SQLException {
        statement.setInt(1, reservationParkingSpace.getParkingSpace().getId());
        statement.setInt(2, reservationParkingSpace.getReservation().getId());
        return statement;
    }

    private String buildMessage(ReservationParkingSpace reservationParkingSpace){
        Map<String,String> idNames = new HashMap<String, String>();
        idNames.put("reservation",Integer.toString(reservationParkingSpace.getReservation().getId()));
        idNames.put("parkingSpace",Integer.toString(reservationParkingSpace.getParkingSpace().getId()));
        return ErrorStringBuilder.buildAddErrorString(idNames);
    }
}
