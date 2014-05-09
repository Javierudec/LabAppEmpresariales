package es.udc.fi.asi.model.department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import es.udc.fi.asi.model.employee.Employee;
import es.udc.fi.asi.model.util.exceptions.InstanceNotFoundException;

public class JdbcDepartmentDAO implements DepartmentDAO {
	
	private DataSource dataSource;
	
	public Department insert(Department department) {		
		if(department == null)
		{
			return null;
		}
		
		try
		{
			Connection connection = dataSource.getConnection();

			PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO employee (name, location) " + 
					"VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, department.getName());
			statement.setString(2, department.getLocation());
			
			statement.executeUpdate();
			
			ResultSet resultSet = statement.getGeneratedKeys();
			
			if (resultSet != null && resultSet.next())
			{
				department.setId(resultSet.getInt(1));
			}			
		}
		catch(SQLException e)
		{
			throw new RuntimeException(e);
		}
		
		return department;
	}
	
	public Department find(Integer departmentId) 
		throws InstanceNotFoundException {
		
		Department department = null;
		
		try {
			Connection connection = dataSource.getConnection();
			
			PreparedStatement statement = connection.prepareStatement(
					"SELECT name, location FROM department WHERE id = ?");
			statement.setInt(1, departmentId);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				String name = resultSet.getString(1);
				String location =  resultSet.getString(2);
				
				department = new Department(departmentId, name, location);
			} else {
				throw new InstanceNotFoundException();
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return department;
	}
	
	public void update(Department department) {
		try {
			
			Connection connection = dataSource.getConnection();

			PreparedStatement statement = connection.prepareStatement(
					"UPDATE department SET name = ?, location = ? " + 
					"WHERE id = ?");
			
			statement.setString(1, department.getName());
			statement.setString(2, department.getLocation());
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void remove(Integer departmentId) {
		try {
			
			Connection connection = dataSource.getConnection();

			PreparedStatement statement = connection.prepareStatement(
					"DELETE FROM department WHERE id = ?");
			statement.setInt(1, departmentId);
			
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Department> findDepartmentsByLocation(String location) {
		List<Department> list = new ArrayList<Department>(); 
		
		try {
			
			Connection connection = dataSource.getConnection();

			PreparedStatement statement = connection.prepareStatement(
					"SELECT id, name, location " + 
					"FROM department WHERE location = ?");
			
			statement.setString(1, location);
			
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				
				list.add(new Department(
						resultSet.getInt(1),	// id
						resultSet.getString(2), // name
						resultSet.getString(3)) // job
				);

			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} 
		
		return list;
	}
	
}
