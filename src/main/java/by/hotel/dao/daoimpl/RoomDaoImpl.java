package by.hotel.dao.daoimpl;

import by.hotel.bean.Room;
<<<<<<< HEAD
import by.hotel.dao.AbstractDao;
import by.hotel.dao.RoomDao;
import by.hotel.dao.exception.DAOException;

=======
import by.hotel.bean.User;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.Constants;
import by.hotel.dao.RoomDao;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
>>>>>>> 7a10bbf86e232785ae7012f86561075f62debe5d
import java.util.List;

public class RoomDaoImpl extends AbstractDao implements RoomDao {

    public List<Room> getRooms() throws DAOException {
<<<<<<< HEAD
        return null;
=======
        Connection connection;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        List<Room> rooms=new ArrayList<Room>();
        try {
            connection=getConnection();
            statement=connection.prepareStatement(Constants.GET_ALL_ROOMS);
            resultSet=statement.executeQuery();
            while(resultSet.next()){
                Room room=new Room();
                room.setId(resultSet.getInt("id"));
                room.setRoomsCount(resultSet.getInt("rooms_count"));
                room.setBedsCount(resultSet.getInt("beds_count"));
                room.setCostPerDay(resultSet.getInt("cost_per_day"));
                room.setAdditionalInfo(resultSet.getString("additional_info"));
                room.setFloor(resultSet.getInt("floor"));
                room.setPhone(resultSet.getString("phone"));
                rooms.add(room);
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
        return rooms;
>>>>>>> 7a10bbf86e232785ae7012f86561075f62debe5d
    }

    public void addRoom(Room room) throws DAOException {

    }

    public void removeRoom(Room room) throws DAOException {

    }

    public void updateRoom(Room room) throws DAOException {

    }
}
