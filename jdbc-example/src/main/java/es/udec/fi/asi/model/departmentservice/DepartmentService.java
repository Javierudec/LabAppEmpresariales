package es.udec.fi.asi.model.departmentservice;

import java.util.List;

import es.udc.fi.asi.model.department.Department;
import es.udc.fi.asi.model.util.exceptions.InstanceNotFoundException;

public interface DepartmentService {
	public Department findDepartmentById(Integer id) throws InstanceNotFoundException;
	public List<Department> findDepartmentsByLocation(String location) throws InstanceNotFoundException;	
}
