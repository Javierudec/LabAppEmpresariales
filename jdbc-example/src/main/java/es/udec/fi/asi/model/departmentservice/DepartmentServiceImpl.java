package es.udec.fi.asi.model.departmentservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;

import es.udc.fi.asi.model.department.Department;
import es.udc.fi.asi.model.department.DepartmentDAO;
import es.udc.fi.asi.model.employee.Employee;
import es.udc.fi.asi.model.employee.EmployeeDAO;
import es.udc.fi.asi.model.util.exceptions.InstanceNotFoundException;

public class DepartmentServiceImpl implements DepartmentService {
	private EmployeeDAO employeeDAO;
	private DepartmentDAO departmentDAO;
	private PlatformTransactionManager transactionManager;
	
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
	
	public Department findDepartmentById(Integer id)
			throws InstanceNotFoundException {
		
		TransactionStatus transactionStatus =
				transactionManager.getTransaction(null);
		Department department = null;
		
		try {
			department = departmentDAO.find(id); 
		
			transactionManager.commit(transactionStatus);	// COMMIT
			
		} catch (RuntimeException e) {
			transactionManager.rollback(transactionStatus);	// ROLLBACK
			
			/* TODO Aquí habría que hacer una gestión de excepciones mejor... */
			throw e;
		}
		
		return department;
	}

	public List<Department> findDepartmentsByLocation(String location)
			throws InstanceNotFoundException {
		List<Department> arrToReturn = new ArrayList<Department>();
		
		TransactionStatus transactionStatus =
				transactionManager.getTransaction(null);
		
		try {
			arrToReturn = departmentDAO.findDepartmentsByLocation(location);
		
			transactionManager.commit(transactionStatus);	// COMMIT
			
		} catch (RuntimeException e) {
			transactionManager.rollback(transactionStatus);	// ROLLBACK
			
			/* TODO Aquí habría que hacer una gestión de excepciones mejor... */
			throw e;
		}
		
		return arrToReturn;
	}

}
