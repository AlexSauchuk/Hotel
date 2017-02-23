package by.hotel.dao;


import by.hotel.bean.Employee;

/**
 * @author SK
 * @version 1.0
 * @created 16-���-2017 18:46:17
 */
public interface EmployeesService {

	public Employee CreateEmployee();

	/**
	 * 
	 * @param id
	 */
	public boolean DeleteEmployee(int id);

	/**
	 * 
	 * @param id
	 */
	public Employee FindByPK(int id);

	/**
	 * 
	 * @param id
	 * @param _employee
	 */
	public boolean UpdateEmployee(int id, Employee _employee);

}