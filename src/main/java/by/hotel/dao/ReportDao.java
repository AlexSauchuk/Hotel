package by.hotel.dao;

import by.hotel.bean.Report;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;

public interface ReportDao {
    Report getFinancialReportInfoByMonth(Report report, Connection connection) throws DAOException;
    Report getFinancialReportInfoByQuarter(Report report, Connection connection) throws DAOException;
    Report getRoomReportInfoByQuarter(Report report, Connection connection) throws DAOException;
    Report getRoomReportInfoByMonth(Report report, Connection connection) throws DAOException;
}
