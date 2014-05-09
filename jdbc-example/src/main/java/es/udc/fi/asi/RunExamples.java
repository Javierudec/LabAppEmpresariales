package es.udc.fi.asi;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import es.udc.fi.asi.model.department.Department;
import es.udc.fi.asi.model.employee.Employee;
import es.udc.fi.asi.model.employeeservice.EmployeeService;
import es.udec.fi.asi.model.departmentservice.DepartmentService;

public class RunExamples {
	
    public static void main(String[] args) throws Exception {
    	
    	ApplicationContext context = 
    			new ClassPathXmlApplicationContext("spring-module.xml");
    	
    	EmployeeService employeeService =
    			(EmployeeService) context.getBean("employeeServiceBean");
    	
    	DepartmentService departmentService = (DepartmentService)context.getBean("departmentServiceBean");
    	
    	Employee e = employeeService.findEmployeeById(7369);
    	//System.out.println(e);
    	
    	ArrayList<Employee> eByDepartment = (ArrayList<Employee>) employeeService.findEmployeesByDepartment(20);
    	System.out.println("");
    	System.out.println("LABORATORIO 02: JDBC");
    	System.out.println("Lista de empleados del departamento 20:");
    	for(int i = 0; i < eByDepartment.size(); i++)
    	{
    		System.out.println(eByDepartment.get(i));
    	}
    	
    	System.out.println("Incrementando salario de los empleados del departamento 20 en 5%");
    	employeeService.increaseSalaryByDepartmentId(20, 1.05f);
    	
    	System.out.println("");
    	System.out.println("Departamento con ID: 20");
    	Department d = departmentService.findDepartmentById(20);
    	System.out.println("Nombre: " + d.getName() + ", Ubicacion: " + d.getLocation());
    	
    	System.out.println("");
    	System.out.println("Departamentos ubicados en Chicago");
    	ArrayList<Department> dByLocation = (ArrayList<Department>) departmentService.findDepartmentsByLocation("CHICAGO");
    	for(int i = 0; i < dByLocation.size(); i++)
    	{
    		System.out.println(dByLocation.get(i));
    	}
    }
}
