package by.hotel.dao.daoimpl;

import by.hotel.bean.User;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.IUserDao;
import by.hotel.dao.exception.DAOException;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by user1 on 16.03.2017.
 */
public class UserDao extends AbstractDao implements IUserDao {

    public ArrayList<User> getUsers() throws DAOException {
        final String GET_ALL_USERS = "SELECT passport_number,name,surname,sex,mobile_phone,login,password FROM db_hotel.user";
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        ArrayList<User> users=new ArrayList<User>();
        try {
            connection=getConnection();
            statement=connection.prepareStatement(GET_ALL_USERS);
            resultSet=statement.executeQuery();
            while(resultSet.next()){
                User user=new User();
                user.setPassportNumber(resultSet.getString("passport_number"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setSex(resultSet.getString("sex"));
                user.setMobilePhone(resultSet.getString("mobile_phone"));
                user.setPassword(resultSet.getString("password"));
                user.setLogin(resultSet.getString("login"));
                users.add(user);
            }
            return users;
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
    }
}
