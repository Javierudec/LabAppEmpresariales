package es.udc.fi.asi.model.employeeservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;

import es.udc.fi.asi.model.department.DepartmentDAO;
import es.udc.fi.asi.model.employee.Employee;
import es.udc.fi.asi.model.employee.EmployeeDAO;
import es.udc.fi.asi.model.util.exceptions.InstanceNotFoundException;

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDAO;
	private DepartmentDAO departmentDAO;
	private PlatformTransactionManager transactionManager;
	
	/**
	 * Finds an employee by its identifier.
	 */
	@Transactional
	public Employee findEmployeeById(Integer id) throws InstanceNotFoundException {
		return employeeDAO.find(id);
	}
	
	/* --------------------- Setter methods --------------------- */
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	@Transactional
	public List<Employee> findEmployeesByDepartment(int id) {
		List<Employee> arrToReturn = new ArrayList<Employee>();
		arrToReturn = employeeDAO.findEmployeesByDepartmentId(id); 
		return arrToReturn;
	}

	@Transactional
	public void increaseSalaryByDepartmentId(int departmentId, float percent) {
		employeeDAO.increaseSalaryByDepartmentId(departmentId, percent);
	}
	
}
