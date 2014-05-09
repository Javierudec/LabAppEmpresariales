package es.udc.fi.asi.mvc.web.employee;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.udc.fi.asi.mvc.model.employee.Employee;
import es.udc.fi.asi.mvc.model.employeeservice.EmployeeService;

@Controller
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public void list(Model model) {		
		List<Employee> list = employeeService.getEmployees();
		model.addAttribute("employeeList", list);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Employee form(Model model) {
		return new Employee("Pepe", "Perez", "Pepe@gmail.com");
	}
	
	@RequestMapping(value = "/addEmployeee", method = RequestMethod.POST)
	public String addEmployee(Employee employee) {
		
		System.out.println(employee);
		
		return "redirect:/main/emp/list";
	}
	
	/* EmployeeService */
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
}
