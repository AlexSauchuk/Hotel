package by.hotel.service;


import by.hotel.bean.Employee;

/**
 * @author SK
 * @version 1.0
 * @created 16-���-2017 18:46:17
 */
public interface EmployeesService {

	public Employee createEmployee();

	/**
	 * 
	 * @param id
	 */
	public boolean deleteEmployee(int id);

	/**
	 * 
	 * @param id
	 */
	public Employee findByPK(int id);

	/**
	 * 
	 * @param id
	 * @param _employee
	 */
	public boolean updateEmployee(int id, Employee _employee);

}