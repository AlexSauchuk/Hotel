package by.hotel.dao.daoimpl;

import by.hotel.bean.*;
import by.hotel.dao.AbstractDao;
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

public class DiscountTypeDaoImpl extends AbstractDao implements DiscountTypeDao {
    static final Logger logger = LogManager.getLogger(DiscountTypeDaoImpl.class.getName());

    public List<DiscountType> getDiscountTypes() throws DAOException {
        Connection connection;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<DiscountType> discountTypes = new ArrayList<DiscountType>();
        try {
            connection = getConnection();
            statement = connection.prepareStatement(Constants.GET_ALL_DISCOUNT_TYPES);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                discountTypes.add(fillDiscountType(resultSet));
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
        return discountTypes;
    }

    public void addDiscountType(DiscountType discountType) throws DAOException {
        Connection connection;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(ADD_DISCOUNT_TYPE);
            statement = fillStatement(statement, discountType);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            finalize(statement);
        }
    }

    public void removeDiscountType(DiscountType discountType) throws DAOException {
        Connection connection;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement.setInt(1, discountType.getId());
            statement = connection.prepareStatement(REMOVE_DISCOUNT_TYPE);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            finalize(statement);
        }
    }

    public void updateDiscountType(DiscountType discountType) throws DAOException {
        Connection connection;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(UPDATE_DISCOUNT_TYPE);
            statement = fillStatement(statement, discountType);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            finalize(statement);
        }
    }

    public DiscountType getDiscountType(Integer id) throws DAOException {
        return null;
    }

    private PreparedStatement fillStatement(PreparedStatement statement, DiscountType discountType) throws SQLException {
        statement.setString(1, discountType.getName());
        statement.setFloat(2, discountType.getAmount());
        return statement;
    }

    private DiscountType fillDiscountType(ResultSet resultSet) throws SQLException {
        DiscountType discountType = new DiscountType();
        discountType.setId(resultSet.getInt("id"));
        discountType.setName(resultSet.getString("name"));
        discountType.setAmount(resultSet.getFloat("amount"));

        return discountType;
    }
}
