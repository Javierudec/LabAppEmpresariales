package es.udc.fi.asi.mvc.model.employee;

public class Employee {
	
	private String name;
	private String surname;
	private String email;
	
	public Employee() {}
	
	public Employee(String name, String surname, String email) {
		this.name = name;
		this.surname = surname;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", surname=" + surname + "]";
	}	

}
