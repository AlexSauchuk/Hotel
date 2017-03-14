package by.hotel.service.impl;


import by.hotel.bean.Report;
import by.hotel.bean.User;
import by.hotel.service.ReportService;

import java.util.ArrayList;

/**
 * @author SK
 * @version 1.0
 * @created 16-���-2017 18:46:18
 */
public class ReportServiceImpl implements ReportService {

	public ReportServiceImpl(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param _user
	 * @param _report
	 */
	public boolean CreateReport(User _user, Report _report){
		return false;
	}

	/**
	 * 
	 * @param id
	 * @param _user
	 */
	public boolean DeleteReport(int id, User _user){
		return false;
	}

	public ArrayList<Report> GetReports(){
		return null;
	}

	/**
	 * 
	 * @param id
	 * @param _user
	 */
	public boolean PrintReport(int id, User _user){
		return false;
	}

}