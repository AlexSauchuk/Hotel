package by.hotel.dao.daoimpl;

import by.hotel.bean.*;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.RegistrationCardDao;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.hotel.dao.constants.Constants.*;

public class RegistrationCardDaoImpl extends AbstractDao implements RegistrationCardDao {
    public List<Integer> getId() throws DAOException {
        return null;
    }

    public List<RegistrationCard> getRegistrationCards() throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<RegistrationCard> registrationCards = new ArrayList<RegistrationCard>();
        try {
            connection = getConnection();
            statement = connection.prepareStatement(GET_ALL_REGISTRATION_CARDS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                registrationCards.add(fillRegistrationCard(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeConnection(connection, statement, resultSet);
        }
        return registrationCards;
    }

    public void addRegistrationCard(RegistrationCard registrationCard) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(ADD_REGISTRATION_CARD);
            statement = fillStatement(statement, registrationCard);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeConnection(connection, statement, null);
        }
    }

    public void removeRegistrationCard(RegistrationCard registrationCard) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(REMOVE_REGISTRATION_CARD);
            statement.setInt(1, registrationCard.getId());
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeConnection(connection, statement, null);
        }
    }

    public void updateRegistrationCard(RegistrationCard registrationCard) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(UPDATE_REGISTRATION_CARD);
            statement = fillStatement(statement, registrationCard);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeConnection(connection, statement, null);
        }
    }

    public RegistrationCard getRegistrationCard(Integer id) throws DAOException {
        return null;
    }

    private PreparedStatement fillStatement(PreparedStatement statement, RegistrationCard registrationCard) throws SQLException {
        statement.setInt(1, registrationCard.getId());
        statement.setInt(2, registrationCard.getParkingSpace().getId());
        statement.setInt(3, registrationCard.getPayment().getId());
        statement.setInt(4, registrationCard.getRoom().getId());
        statement.setInt(5, registrationCard.getUser().getId());

        return statement;
    }

    private RegistrationCard fillRegistrationCard(ResultSet resultSet) throws SQLException {
        RegistrationCard registrationCard = new RegistrationCard();
        registrationCard.setId(resultSet.getInt("id"));

        Payment payment = new Payment();
        payment.setId(resultSet.getInt("id"));
        payment.setCount_paid_days(resultSet.getInt("count_paid_days"));
        payment.setSum(resultSet.getInt("sum"));

        Discount discount = new Discount();

        DiscountType discountType = new DiscountType();
        discountType.setId(resultSet.getInt("discount.id"));
        discountType.setName(resultSet.getString("name"));
        discountType.setAmount(resultSet.getFloat("amount"));

        discount.setId(resultSet.getInt("id"));
        discount.setDiscountType(discountType);
        payment.setDiscount(discount);

        registrationCard.setPayment(payment);

        Room room = new Room();

        RoomType roomType = new RoomType(resultSet.getInt("room_type.id"),
                resultSet.getInt("rooms_count"),
                resultSet.getInt("beds_count"),
                resultSet.getInt("cost_per_day"),
                resultSet.getString("additional_info"));
        room.setId(resultSet.getInt("id"));
        room.setRoomType(roomType);
        room.setFloor(resultSet.getInt("floor"));
        room.setPhone(resultSet.getString("phone"));

        registrationCard.setRoom(room);

        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setPassportNumber(resultSet.getString("passport_number"));
        user.setName(resultSet.getString("name"));
        user.setSurname(resultSet.getString("surname"));
        user.setSex(resultSet.getString("sex"));
        user.setMobilePhone(resultSet.getString("mobile_phone"));
        user.setPassword(resultSet.getString("password"));
        user.setLogin(resultSet.getString("login"));

        registrationCard.setUser(user);

        ParkingSpace parkingSpace = new ParkingSpace();
        parkingSpace.setId(resultSet.getInt("id"));
        parkingSpace.setId(resultSet.getInt("level"));
        parkingSpace.setReserved(resultSet.getBoolean("is_reserved"));

        registrationCard.setParkingSpace(parkingSpace);

        return registrationCard;
    }
}
