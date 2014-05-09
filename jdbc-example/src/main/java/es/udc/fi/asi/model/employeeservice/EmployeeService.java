package es.udc.fi.asi.model.employeeservice;

import java.util.List;

import es.udc.fi.asi.model.employee.Employee;
import es.udc.fi.asi.model.util.exceptions.InstanceNotFoundException;

/**
 * Employee service.
 */
public interface EmployeeService {
	
	/**
	 * Finds the data of an employee from the employee's id.
	 */
	public Employee findEmployeeById(Integer id) throws InstanceNotFoundException;
	public List<Employee> findEmployeesByDepartment(int id) throws InstanceNotFoundException;	
	public void increaseSalaryByDepartmentId(int departmentId, float percent);
}
