package es.udc.fi.asi.mvc.web.department;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.udc.fi.asi.mvc.model.department.Department;
import es.udc.fi.asi.mvc.model.departmentservice.DepartmentService;

@Controller
public class DepartmentController {
	
	private DepartmentService departmentService;
	
	@RequestMapping(method = RequestMethod.GET)
	public void list(Model model) {		
		List<Department> list = departmentService.getDepartments();
		model.addAttribute("departmentList", list);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Department form(Model model) {
		return new Department(0, "No name", "No location");
	}
	
	@RequestMapping(value = "/addDepartment", method = RequestMethod.POST)
	public String addDepartment(Department department) {
		
		System.out.println(department);
		
		return "redirect:/main/dep/list";
	}
	
	/* EmployeeService */
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
}
