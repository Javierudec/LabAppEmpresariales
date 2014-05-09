package es.udc.fi.asi.mvc.model.employeeservice;

import java.util.ArrayList;
import java.util.List;

import es.udc.fi.asi.mvc.model.employee.Employee;

public class EmployeeService {
	
	/*
	 * Returns an employee list. 
	 */
	public List<Employee> getEmployees() {
		
		List<Employee> list = new ArrayList<Employee>();
		
		list.add(new Employee("Carrie", "Mathison", "Carrie@gmail.com"));
		list.add(new Employee("Saul", "Berenson", "Saul@gmail.com"));
		list.add(new Employee("Peter", "Quinn", "Peter@gmail.com"));
		list.add(new Employee("Nicholas", "Brody", "Nicholas@gmail.com"));
		
		return list;
	}

}
