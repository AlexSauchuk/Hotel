package by.hotel.service.impl;

import by.hotel.bean.Report;
import by.hotel.dao.ReportDao;
import by.hotel.dao.exception.DAOException;
import by.hotel.dao.impl.ReportDaoImpl;
import by.hotel.service.AbstractService;
import by.hotel.service.exception.ServiceException;

import java.sql.Connection;

public class ReportServiceImpl extends AbstractService{
	private ReportDao reportDao = new ReportDaoImpl();

	public Report getFinancialReportInfoByMonth(Report report) throws ServiceException{
        Connection connection = null;
        try {
            connection = getConnection();
            report = reportDao.getFinancialReportInfoByMonth(report, connection);
        }catch (DAOException e){
            new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
        return report;
    }

    public Report getFinancialReportInfoByQuarter(Report report) throws ServiceException{
        Connection connection = null;
        try {
            connection = getConnection();
            report = reportDao.getFinancialReportInfoByQuarter(report, connection);
        }catch (DAOException e){
            new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
        return report;
    }

    public Report getRoomReportInfoByMonth(Report report) throws ServiceException{
        Connection connection = null;
        try {
            connection = getConnection();
            report = reportDao.getRoomReportInfoByMonth(report, connection);
        }catch (DAOException e){
            new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
        return report;
    }

    public Report getRoomReportInfoByQuarter(Report report) throws ServiceException{
        Connection connection = null;
        try {
            connection = getConnection();
            report = reportDao.getRoomReportInfoByQuarter(report, connection);
        }catch (DAOException e){
            new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
        return report;
    }
}