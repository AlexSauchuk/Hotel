package by.hotel.dao;

import by.hotel.bean.RegistrationCard;
import by.hotel.dao.exception.DAOException;

import java.util.List;

public interface RegistrationCardDao {
    List<Integer> getId() throws DAOException;
    List<RegistrationCard> getRegistrationCards() throws DAOException;
    void addRegistrationCard(RegistrationCard registrationCard) throws DAOException;
    void removeRegistrationCard(RegistrationCard registrationCard) throws DAOException;
    void updateRegistrationCard(RegistrationCard registrationCard) throws DAOException;
}
