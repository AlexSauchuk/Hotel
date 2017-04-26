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
        List<ReservationParkingSpace> reservationParkingSpaces = new ArrayList<ReservationParkingSpace>();
        UserBuilder userBuilder = new UserBuilder();
        DiscountBuilder discountBuilder = new DiscountBuilder();
        ReservationBuilder reservationBuilder = new ReservationBuilder();
        ParkingSpaceBuilder parkingSpaceBuilder = new ParkingSpaceBuilder();
        ReservationParkingSpaceBuilder reservationParkingSpaceBuilder = new ReservationParkingSpaceBuilder();
        try {
            statement = connection.prepareStatement(GET_ALL_RESERVATION_PARKING_SPACES);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                reservationParkingSpaces.add(reservationParkingSpaceBuilder
                                    .reservation(reservationBuilder.id(resultSet.getInt("id_reservation"))
                                        .dateIn(resultSet.getDate("date-in"))
                                        .dateOut(resultSet.getDate("date-out"))
                                        .user(userBuilder.id(resultSet.getInt("id_user"))
                                                .passportNumber(resultSet.getString("passport_number"))
                                                .name(resultSet.getString("name"))
                                                .surname(resultSet.getString("surname"))
                                                .sex(resultSet.getString("sex"))
                                                .mobilePhone(resultSet.getString("mobile_phone"))
                                                .build())
                                        .costAdditionalServices(resultSet.getInt("cost_additional_services"))
                                        .discount(discountBuilder.id(resultSet.getInt("discount_id"))
                                                .name(resultSet.getString("discount_name"))
                                                .build())
                                        .build())
                                    .parkingSpace(parkingSpaceBuilder.id(resultSet.getInt("id_parking_space"))
                                        .level(resultSet.getInt("level"))
                                        .reserved(resultSet.getByte("is_reserved"))
                                        .build())
                                    .build());
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
        }catch (SQLException e) {
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
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(UPDATE_RESERVATION_PARKING_SPACE);
            statement = fillStatement(statement, reservationParkingSpace);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
    }
    private PreparedStatement fillStatement(PreparedStatement statement, ReservationParkingSpace reservationParkingSpace) throws SQLException {
        statement.setInt(1, reservationParkingSpace.getParkingSpace().getId());
        statement.setInt(2, reservationParkingSpace.getReservation().getId());
        return statement;
    }

    private String buildMessage(ReservationParkingSpace reservationParkingSpace){
        Map<String,String> idNames = new HashMap<String, String>();
        idNames.put("reservation",Integer.toString(reservationParkingSpace.getReservation().getId()));
        idNames.put("parking_space",Integer.toString(reservationParkingSpace.getParkingSpace().getId()));
        return ErrorStringBuilder.buildAddErrorString(idNames);
    }
}
