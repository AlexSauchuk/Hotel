package by.hotel.dao.daoimpl;

import by.hotel.bean.Discount;
import by.hotel.bean.ParkingSpace;
import by.hotel.builder.DiscountBuilder;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.DiscountDao;
import by.hotel.dao.exception.DAOException;
import by.hotel.util.ErrorStringBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.hotel.dao.constants.Constants.*;

public class DiscountDaoImpl extends AbstractDao implements DiscountDao {
    public List<Integer> getId() throws DAOException {
        return null;
    }

    public List<Discount> getDiscounts() throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Discount> discounts = new ArrayList<Discount>();
        DiscountBuilder discountBuilder = new DiscountBuilder();
        try {
            connection = getConnection();
            statement = connection.prepareStatement(GET_ALL_DISCOUNTS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                discounts.add(fillDiscount(resultSet, discountBuilder));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeConnection(connection, statement, resultSet);
        }
        return discounts;
    }

    public void addDiscount(Discount discount) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(ADD_DISCOUNT);
            statement = fillStatement(statement, discount);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeConnection(connection, statement, null);
        }
    }

    public void removeDiscount(Discount discount) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(REMOVE_DISCOUNT);
            statement.setInt(1, discount.getId());
            statement.execute();
        }catch (SQLIntegrityConstraintViolationException e){
            throw new DAOException(buildMessage(discount, e.getMessage()),e);
        }catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeConnection(connection, statement, null);
        }
    }

    public void updateDiscount(Discount discount) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(UPDATE_DISCOUNT);
            statement = fillStatement(statement, discount);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeConnection(connection, statement, null);
        }
    }

    public Discount getDiscount(Integer id) throws DAOException {
        return null;
    }

    private PreparedStatement fillStatement(PreparedStatement statement, Discount discount) throws SQLException {
        statement.setString(1, discount.getName());
        statement.setInt(2, discount.getId());
        return statement;
    }

    private Discount fillDiscount(ResultSet resultSet, DiscountBuilder discountBuilder) throws SQLException {
        return discountBuilder.id(resultSet.getInt("id"))
                              .name(resultSet.getString("name"))
                              .build();
    }

    private String buildMessage(Discount discount, String errorMessage){
        Map<String,String> idNames = new HashMap<String, String>();
        idNames.put("id",Integer.toString(discount.getId()));
        return ErrorStringBuilder.buildErrorString(idNames, errorMessage);
    }
}