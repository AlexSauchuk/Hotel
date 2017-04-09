package by.hotel.dao.daoimpl;

import by.hotel.bean.Discount;
import by.hotel.bean.DiscountType;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.DiscountDao;
import by.hotel.dao.DiscountTypeDao;
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
public class DiscountDaoImpl extends AbstractDao implements DiscountDao {
    static final Logger logger = LogManager.getLogger(DiscountDaoImpl.class.getName());

    public List<Discount> getDiscounts() throws DAOException {
        Connection connection;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Discount> discounts = new ArrayList<Discount>();
        try {
            connection = getConnection();
            statement = connection.prepareStatement(Constants.GET_ALL_DISCOUNTS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                discounts.add(fillDiscount(resultSet));
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
        return discounts;
    }

    public void addDiscount(Discount discount) throws DAOException {
        Connection connection;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(ADD_DISCOUNT);
            statement = fillStatement(statement, discount);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            finalize(statement);
        }
    }

    public void removeDiscount(Discount discount) throws DAOException {
        Connection connection;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement.setInt(1, discount.getId());
            statement = connection.prepareStatement(REMOVE_DISCOUNT);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            finalize(statement);
        }
    }

    public void updateDiscount(Discount discount) throws DAOException {
        Connection connection;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(UPDATE_DISCOUNT);
            statement = fillStatement(statement, discount);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            finalize(statement);
        }
    }

    public Discount getDiscount(Integer id) throws DAOException {
        return null;
    }

    private PreparedStatement fillStatement(PreparedStatement statement, Discount discount) throws SQLException {
        statement.setInt(1, discount.getDiscountType().getId());
        return statement;
    }

    private Discount fillDiscount(ResultSet resultSet) throws SQLException {
        Discount discount = new Discount();

        DiscountType discountType = new DiscountType();
        discountType.setId(resultSet.getInt("id"));
        discountType.setName(resultSet.getString("name"));
        discountType.setAmount(resultSet.getFloat("amount"));

        discount.setDiscountType(discountType);
        discount.setId(resultSet.getInt("id"));

        return discount;
    }
}
