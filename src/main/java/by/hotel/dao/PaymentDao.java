package by.hotel.dao;

import by.hotel.bean.Payment;
import by.hotel.dao.exception.DAOException;

import java.util.List;

/**
 * Created by 1 on 06.04.2017.
 */
public interface PaymentDao {
    List<Payment> getPayments() throws DAOException;

    void addPayment(Payment payment) throws DAOException;

    void removePayment(Payment payment) throws DAOException;

    void updatePayment(Payment payment) throws DAOException;

    Payment getPayment(Integer id) throws DAOException;
}
