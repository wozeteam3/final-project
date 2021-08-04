package com.t3.finalproject.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.t3.finalproject.model.Employee;

@Configuration
@Service
public class EmployeeService {
	
	protected DataSource datasource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String GET_BY_ID = "SELECT * FROM employee WHERE emp_id = ?";

	public EmployeeService(final JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		datasource = this.jdbcTemplate.getDataSource();
	}

	
	public Employee getId(int id) {
		ResultSet rs;
		
		Employee result = null;
		
		try (Connection c = datasource.getConnection()) {
			final PreparedStatement ps = c.prepareStatement(GET_BY_ID);
			
			ps.setLong(1, id);
			
			
			rs = ps.executeQuery();
			
			if(rs.next() != false) {
				result = new Employee();
				
				result.setEmpId(rs.getInt(1));
				result.setFirstName(rs.getString(3));
			} else {
				System.out.println("ID not Found");
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public List<Employee> getAll() {
		return null;
	}
	
	public void delete(Employee e) {
	
	}
	
	public void update(Employee e) {
		
	}
	
	public void create(Employee e) {
		
	}
}
