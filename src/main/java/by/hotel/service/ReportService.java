package by.hotel.service;


import by.hotel.bean.Report;
import by.hotel.bean.User;

import java.util.ArrayList;

/**
 * @author SK
 * @version 1.0
 * @created 16-���-2017 18:46:17
 */
public interface ReportService {

	/**
	 * 
	 * @param _user
	 * @param _report
	 */
	public boolean CreateReport(User _user, Report _report);

	/**
	 * 
	 * @param id
	 * @param _user
	 */
	public boolean DeleteReport(int id, User _user);

	public ArrayList<Report> GetReports();

	/**
	 * 
	 * @param id
	 * @param _user
	 */
	public boolean PrintReport(int id, User _user);

}