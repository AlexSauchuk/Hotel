package by.hotel.dao.daoimpl;

import by.hotel.bean.Reservation;
import by.hotel.builder.DiscountBuilder;
import by.hotel.builder.ReservationBuilder;
import by.hotel.builder.UserBuilder;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.ReservationDao;
import by.hotel.dao.constants.Constants;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.hotel.dao.constants.Constants.*;

public class ReservationDaoImpl extends AbstractDao implements ReservationDao {
    public List<Reservation> getAllReservations(Connection connection) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Reservation> reservations = new ArrayList<Reservation>();
        UserBuilder userBuilder = new UserBuilder();
        DiscountBuilder discountBuilder = new DiscountBuilder();
        ReservationBuilder reservationBuilder = new ReservationBuilder();
        try {
            statement = connection.prepareStatement(Constants.GET_ALL_RESERVATIONS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                reservations.add(reservationBuilder.id(resultSet.getInt("id"))
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
                                    .build());
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, resultSet);
        }
        return reservations;
    }

    public void addReservation(Reservation reservation,Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(ADD_RESERVATION);
            statement = fillStatement(statement, reservation);
            statement.execute();
        } catch (SQLException e) {
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
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
    }

    public Reservation getReservation(Integer id,Connection connection) throws DAOException {
        return null;
    }

    private PreparedStatement fillStatement(PreparedStatement statement, Reservation reservation) throws SQLException {
        statement.setInt(1, reservation.getUser().getId());
        statement.setDate(2, reservation.getDateIn());
        statement.setDate(3, reservation.getDateOut());
        return statement;
    }
}
