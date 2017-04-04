package by.hotel.dao.daoimpl;


import by.hotel.bean.ReservationInfo;
import by.hotel.bean.User;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.ReservationDao;
import by.hotel.dao.exception.DAOException;

import java.util.List;

public class ReservationDaoImpl extends AbstractDao implements ReservationDao {


/*    public static class ExecuteQuery implements Callable {
        PreparedStatement preparedStatement;
        public ExecuteQuery(PreparedStatement preparedStatement) {
            this.preparedStatement = preparedStatement;
        }
        public PreparedStatement call() {
            try {
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return preparedStatement;
        }
    }*/

    public boolean register(User user) {

/*        ExecutorService executorService = Executors.newCachedThreadPool();

        final String INSERT = "INSERT  INTO user (name,password) VALUES (?,?)";
        final String CHECK = "SELECT * FROM user WHERE login = ?";

        ResultSet resultSet;
        DBWorker worker = new DBWorker();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = worker.getConnection().prepareStatement(CHECK);
            preparedStatement.setString(1,user.getName());
            Set<Future<PreparedStatement>> set = new HashSet();
            Callable<PreparedStatement> callableCheck = new ExecuteQuery(preparedStatement);
            Future<PreparedStatement> future = executorService.submit(callableCheck);
            set.add(future);
            try {
                preparedStatement = future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()){
                return false;
            }else {
                preparedStatement = worker.getConnection().prepareStatement(INSERT);
                preparedStatement.setString(1,user.getName());
                preparedStatement.setString(2,user.getPassword());
                Callable<PreparedStatement> callableInsert = new ExecuteQuery(preparedStatement);
                future = executorService.submit(callableInsert);
                try {
                    preparedStatement = future.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
            preparedStatement.close();
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
        return  false;
    }

    public boolean authorization(User user) {
/*        final String dbRequest = "SELECT id,password FROM user WHERE login = ?";

        String name = user.getName();
        String password = user.getPassword();

        ExecutorService executorService = Executors.newCachedThreadPool();
        DBWorker worker = new DBWorker();
        ResultSet resultSet;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = worker.getConnection().prepareStatement(dbRequest);
            preparedStatement.setString(1,name);
            Set<Future<PreparedStatement>> set = new HashSet();
            Callable<PreparedStatement> callableSelect= new ExecuteQuery(preparedStatement);
            Future<PreparedStatement> future = executorService.submit(callableSelect);
            set.add(future);
            try {
                preparedStatement = future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            resultSet = preparedStatement.getResultSet();
            resultSet.next();
            if (resultSet.getString("password").equals(password)){
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Драйвер не загружен!");
        }
        finally {
            try {
                if(preparedStatement!=null){
                    preparedStatement.close();
                }
//                worker.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
        return false;
    }

    public List<ReservationInfo> getAllReservationInfo() throws DAOException {
        return null;
    }

    public void addReservationInfo(ReservationInfo room) throws DAOException {

    }

    public void removeReservationInfo(ReservationInfo room) throws DAOException {

    }

    public void updateReservationInfo(ReservationInfo room) throws DAOException {

    }
}
