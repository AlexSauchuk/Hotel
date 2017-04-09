package by.hotel.dao.daoimpl;

import by.hotel.bean.Discount;
import by.hotel.bean.DiscountType;
import by.hotel.bean.Payment;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.PaymentDao;
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
 * Created by 1 on 06.04.2017.
 */
public class PaymentDaoImpl extends AbstractDao implements PaymentDao {
    private static final Logger logger = LogManager.getLogger(PaymentDaoImpl.class.getName());

    public List<Payment> getPayments() throws DAOException {
        Connection connection;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Payment> payments = new ArrayList<Payment>();
        try {
            connection = getConnection();
            statement = connection.prepareStatement(Constants.GET_ALL_PAYMENTS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                payments.add(fillPayment(resultSet));
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
        return payments;
    }

    public void addPayment(Payment payment) throws DAOException {
        Connection connection;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(ADD_PAYMENT);
            statement = fillStatement(statement, payment);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            finalize(statement);
        }
    }

    public void removePayment(Payment payment) throws DAOException {
        Connection connection;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement.setInt(1, payment.getId());
            statement = connection.prepareStatement(REMOVE_PAYMENT);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            finalize(statement);
        }
    }

    public void updatePayment(Payment payment) throws DAOException {
        Connection connection;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(UPDATE_PAYMENT);
            statement = fillStatement(statement, payment);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            finalize(statement);
        }
    }

    public Payment getPayment(Integer id) throws DAOException {
        return null;
    }

    private PreparedStatement fillStatement(PreparedStatement statement, Payment payment) throws SQLException {
        statement.setInt(1, payment.getId());
        statement.setInt(2, payment.getDiscount().getId());
        statement.setInt(3, payment.getCount_paid_days());
        statement.setInt(4, payment.getSum());
        return statement;
    }

    private Payment fillPayment(ResultSet resultSet) throws SQLException {
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

        return payment;
    }
}
