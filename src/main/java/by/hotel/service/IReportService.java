package by.hotel.service;


import by.hotel.bean.Report;
import by.hotel.bean.User;

import java.util.ArrayList;

/**
 * @author SK
 * @version 1.0
 * @created 16-���-2017 18:46:17
 */
public interface IReportService {

	/**
	 * 
	 * @param user
	 * @param report
	 */
	boolean createReport(User user, Report report);

	/**
	 * 
	 * @param id
	 * @param user
	 */
	boolean deleteReport(int id, User user);

	ArrayList<Report> getReports();

	/**
	 * 
	 * @param id
	 * @param user
	 */
	boolean printReport(int id, User user);

}