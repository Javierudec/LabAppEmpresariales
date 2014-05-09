package es.udc.fi.asi.mvc.model.departmentservice;

import java.util.ArrayList;
import java.util.List;

import es.udc.fi.asi.mvc.model.department.Department;
import es.udc.fi.asi.mvc.model.employee.Employee;

public class DepartmentService {
	
	/*
	 * Returns an employee list. 
	 */
	public List<Department> getDepartments() {
		
		List<Department> list = new ArrayList<Department>();
		
		list.add(new Department(0, "Game development", "Jupiter"));
		list.add(new Department(0, "Game development", "Jupiter"));
		list.add(new Department(0, "Game development", "Jupiter"));
		list.add(new Department(0, "Game development", "Jupiter"));
		
		return list;
	}

}