package by.hotel.dao.daoimpl;

import by.hotel.bean.Discount;
import by.hotel.bean.DiscountType;
import by.hotel.bean.ParkingSpace;
import by.hotel.bean.Payment;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.ParkingSpaceDao;
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
public class ParkingSpaceImpl extends AbstractDao implements ParkingSpaceDao {
    private static final Logger logger = LogManager.getLogger(ParkingSpaceImpl.class.getName());

    public List<ParkingSpace> getParkingSpaces() throws DAOException {
        Connection connection;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<ParkingSpace> parkingSpaces = new ArrayList<ParkingSpace>();
        try {
            connection = getConnection();
            statement = connection.prepareStatement(Constants.GET_ALL_PARKING_SPACES);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                parkingSpaces.add(fillParkingSpace(resultSet));
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
        return parkingSpaces;
    }

    public void addParkingSpace(ParkingSpace parkingSpace) throws DAOException {
        Connection connection;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(ADD_PARKING_SPACE);
            statement = fillStatement(statement, parkingSpace);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            finalize(statement);
        }
    }

    public void removeParkingSpace(ParkingSpace parkingSpace) throws DAOException {
        Connection connection;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement.setInt(1, parkingSpace.getId());
            statement = connection.prepareStatement(REMOVE_PARKING_SPACE);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            finalize(statement);
        }
    }

    public void updateParkingSpace(ParkingSpace parkingSpace) throws DAOException {
        Connection connection;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(UPDATE_PARKING_SPACE);
            statement = fillStatement(statement, parkingSpace);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            finalize(statement);
        }
    }

    public ParkingSpace getParkingSpace(Integer id) throws DAOException {
        return null;
    }

    private PreparedStatement fillStatement(PreparedStatement statement, ParkingSpace parkingSpace) throws SQLException {
        statement.setInt(1, parkingSpace.getId());
        statement.setInt(2, parkingSpace.getLevel());
        statement.setBoolean(3, parkingSpace.isReserved());
        return statement;
    }

    private ParkingSpace fillParkingSpace(ResultSet resultSet) throws SQLException {
        ParkingSpace parkingSpace = new ParkingSpace();
        parkingSpace.setId(resultSet.getInt("id"));
        parkingSpace.setId(resultSet.getInt("level"));
        parkingSpace.setReserved(resultSet.getBoolean("is_reserved"));

        return parkingSpace;
    }
}