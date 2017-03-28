package by.hotel.dao.daoimpl;

import by.hotel.bean.User;
import by.hotel.dao.AbstractDao;
<<<<<<< HEAD
=======
import by.hotel.dao.Constants;
>>>>>>> 7a10bbf86e232785ae7012f86561075f62debe5d
import by.hotel.dao.UserDao;
import by.hotel.dao.exception.DAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
/**
 * Created by user1 on 16.03.2017.
 */
public class UserDaoImpl extends AbstractDao implements UserDao {

    public List<User> getUsers() throws DAOException {
        final String GET_ALL_USERS = "SELECT passport_number,name,surname,sex,mobile_phone,login,password FROM db_hotel.user";
=======
public class UserDaoImpl extends AbstractDao implements UserDao {

    public List<User> getUsers() throws DAOException {
>>>>>>> 7a10bbf86e232785ae7012f86561075f62debe5d
        Connection connection;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        List<User> users=new ArrayList<User>();
        try {
            connection=getConnection();
<<<<<<< HEAD
            statement=connection.prepareStatement(GET_ALL_USERS);
            resultSet=statement.executeQuery();
            while(resultSet.next()){
                User user=new User();
=======
            statement=connection.prepareStatement(Constants.GET_ALL_USERS);
            resultSet=statement.executeQuery();
            while(resultSet.next()){
                User user=new User();
                user.setId(resultSet.getInt("id"));
>>>>>>> 7a10bbf86e232785ae7012f86561075f62debe5d
                user.setPassportNumber(resultSet.getString("passport_number"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setSex(resultSet.getString("sex"));
                user.setMobilePhone(resultSet.getString("mobile_phone"));
                user.setPassword(resultSet.getString("password"));
                user.setLogin(resultSet.getString("login"));
                users.add(user);
            }
        }catch (SQLException e){
            throw new DAOException(e);
        }finally {
            try{
                if(resultSet!=null){
                    resultSet.close();
                }
                if(statement!=null){
                    statement.close();
                }
                closeConnection();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    public void addUser(User user) throws DAOException {

    }

    public void removeUser(User user) throws DAOException {

    }

    public void updateUser(User user) throws DAOException {

    }
}
