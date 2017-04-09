package by.hotel.dao;

import by.hotel.bean.RegistrationCard;
import by.hotel.dao.exception.DAOException;

import java.util.List;

/**
 * Created by 1 on 06.04.2017.
 */
public interface RegistrationCardDao {
    List<RegistrationCard> getRegistrationCards() throws DAOException;

    void addRegistrationCard(RegistrationCard registrationCard) throws DAOException;

    void removeRegistrationCard(RegistrationCard registrationCard) throws DAOException;

    void updateRegistrationCard(RegistrationCard registrationCard) throws DAOException;
}
