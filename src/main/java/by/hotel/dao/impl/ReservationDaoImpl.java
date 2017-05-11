package by.hotel.dao.impl;

import by.hotel.bean.Reservation;
import by.hotel.builder.DiscountBuilder;
import by.hotel.builder.ReservationBuilder;
import by.hotel.builder.UserBuilder;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.ReservationDao;
import by.hotel.dao.constants.Constants;
import by.hotel.dao.exception.DAOException;
import by.hotel.util.ErrorStringBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.hotel.dao.constants.Constants.*;

public class ReservationDaoImpl extends AbstractDao implements ReservationDao {
    public List<String> getReservationHeaders(Connection connection) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<String> headers = new ArrayList<String>();
        StringBuilder stringBuilder = new StringBuilder();
        try {
            statement = connection.prepareStatement(GET_ALL_RESERVATIONS_HEADERS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                stringBuilder.append(resultSet.getInt("id")+" ");
                stringBuilder.append(resultSet.getString("dateIn")+" ");
                stringBuilder.append(resultSet.getString("dateOut"));
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

    public List<Reservation> getAllReservations(Connection connection) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Reservation> reservations = new ArrayList<>();
        ReservationBuilder reservationBuilder = new ReservationBuilder();
        try {
            statement = connection.prepareStatement(Constants.GET_ALL_RESERVATIONS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                reservations.add(fillReservation(resultSet,reservationBuilder));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, resultSet);
        }
        return reservations;
    }

    @Override
    public Reservation getReservation(Integer id, Connection connection) throws DAOException {
        return null;
    }

    public void addReservation(Reservation reservation,Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(ADD_RESERVATION);
            statement = fillStatement(statement, reservation);
            statement.execute();
        } catch (SQLException | NullPointerException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
    }

    public void removeReservation(Reservation reservation,Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(REMOVE_RESERVATION);
            statement.setInt(1, reservation.getId());
            statement.execute();
        }
        catch (SQLIntegrityConstraintViolationException e){
            throw new DAOException(buildMessage(reservation, e.getMessage()),e);
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
    }

    public void updateReservation(Reservation reservation,Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(UPDATE_RESERVATION);
            statement = fillStatement(statement, reservation);
            statement.setInt(6, reservation.getId());
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
    }

    @Override
    public Reservation getLastInsertedReservation(Connection connection) throws DAOException {
        PreparedStatement statement = null;
        Reservation reservation = null;
        ResultSet resultSet;
        ReservationBuilder reservationBuilder = new ReservationBuilder();
        DiscountBuilder discountBuilder = new DiscountBuilder();
        UserBuilder userBuilder = new UserBuilder();
        try {
            statement = connection.prepareStatement(GET_LAST_INSERTED_RESERVATION);
            // statement.setString(1,"reservation");
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                reservation = reservationBuilder.id(resultSet.getInt("id"))
                        .dateIn(resultSet.getDate("dateIn"))
                        .dateOut(resultSet.getDate("dateOut"))
                        .costAdditionalServices(resultSet.getInt("costAdditionalServices"))
                        .user(userBuilder.id(resultSet.getInt("idUser")).build())
                        .discount(discountBuilder.id(resultSet.getInt("idDiscount")).build())
                        .build();
            }
        } catch (SQLException | NullPointerException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
        return reservation;
    }

    private PreparedStatement fillStatement(PreparedStatement statement, Reservation reservation) throws SQLException {
        statement.setInt(1, reservation.getUser().getId());
        statement.setDate(2, reservation.getDateIn());
        statement.setDate(3, reservation.getDateOut());
        statement.setInt(4, reservation.getCostAdditionalServices());
        statement.setInt(5,reservation.getDiscount().getId());
        return statement;
    }

    private Reservation fillReservation(ResultSet resultSet, ReservationBuilder reservationBuilder) throws SQLException {
        UserBuilder userBuilder = new UserBuilder();
        DiscountBuilder discountBuilder = new DiscountBuilder();
        return reservationBuilder.id(resultSet.getInt("id"))
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
                .build();
    }

    private String buildMessage(Reservation reservation, String errorMessage){
        Map<String,String> idNames = new HashMap<String, String>();
        idNames.put("id",Integer.toString(reservation.getId()));
        return ErrorStringBuilder.buildDeleteErrorString(idNames,errorMessage);
    }
}
