package com.t3.finalproject.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

  @Autowired private JdbcTemplate jdbcTemplate;

  private final String GET_ALL = "SELECT * FROM employee";
  private final String GET_BY_ID = "SELECT * FROM employee WHERE emp_id = ?";
  private final String DELETE_BY_ID = "DELETE FROM employee WHERE emp_id = ?";
  private final String CREATE =
      "INSERT INTO employee"
          + " (benefit_id,first_name,last_name,email,phone_num,pay_grade,pay_step,salaried) VALUES"
          + " (?,?,?,?,?,?,?,?)";
  private final String UPDATE =
      "UPDATE employee SET benefit_id = ?, first_name = ?, last_name = ?, email = ?, phone_num = ?,"
          + " pay_grade = ?, pay_step = ?, salaried = ? WHERE emp_id = ?";

  public EmployeeService(final JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
    datasource = this.jdbcTemplate.getDataSource();
  }

  public Employee getId(int id) {
    ResultSet rs;

    Employee result = null;

    try (Connection c = datasource.getConnection()) {
      PreparedStatement ps = c.prepareStatement(GET_BY_ID);

      ps.setLong(1, id);

      rs = ps.executeQuery();

      if (rs.next() != false) {
        result = resultToEmp(rs);
      } else {
        System.out.println("ID not Found");
      }
    } catch (final SQLException e) {
      e.printStackTrace();
    }

    return result;
  }

  public List<Employee> getAll() {
    ResultSet rs;

    List<Employee> result = new ArrayList<Employee>();

    try (Connection c = datasource.getConnection()) {
      PreparedStatement ps = c.prepareStatement(GET_ALL);

      rs = ps.executeQuery();

      while (rs.next()) {
        result.add(resultToEmp(rs));
      }
    } catch (final SQLException e) {
      e.printStackTrace();
    }

    return result;
  }

  public void update(Employee emp) {
    try (Connection c = datasource.getConnection()) {
      PreparedStatement ps = c.prepareStatement(UPDATE);

      ps = empToPreparedStmt(emp, ps);
      ps.setInt(9, emp.getEmpId());

      ps.execute();
    } catch (final SQLException e) {
      e.printStackTrace();
    }
  }

  public void delete(Employee emp) {
    try (Connection c = datasource.getConnection()) {
      PreparedStatement ps = c.prepareStatement(DELETE_BY_ID);

      ps.setInt(1, emp.getEmpId());

      ps.execute();
    } catch (final SQLException e) {
      e.printStackTrace();
    }
  }

  public void create(Employee emp) {
    try (Connection c = datasource.getConnection()) {
      PreparedStatement ps = c.prepareStatement(CREATE);

      ps = empToPreparedStmt(emp, ps);

      ps.execute();
    } catch (final SQLException e) {
      e.printStackTrace();
    }
  }

  public static PreparedStatement empToPreparedStmt(Employee e, PreparedStatement ps)
      throws SQLException {
    ps.setInt(1, e.getBenefitId());
    ps.setString(2, e.getFirstName());
    ps.setString(3, e.getLastName());
    ps.setString(4, e.getEmail());
    ps.setString(5, e.getPhoneNum());
    ps.setInt(6, e.getPayGrade());
    ps.setInt(7, e.getPayStep());
    ps.setBoolean(8, e.isSalaried());

    return ps;
  }

  public static Employee resultToEmp(ResultSet rs) throws SQLException {
    Employee e =
        new Employee(
            rs.getInt(1),
            rs.getInt(2),
            rs.getString(3),
            rs.getString(4),
            rs.getString(5),
            rs.getString(6),
            rs.getInt(7),
            rs.getInt(8),
            rs.getBoolean(9));
    return e;
  }
}
