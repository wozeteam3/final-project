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

// TODO: Auto-generated Javadoc
/** The Class EmployeeService. */
@Configuration
@Service
public class EmployeeService {

  /** The datasource. */
  protected DataSource datasource;

  /** The jdbc template. */
  @Autowired private JdbcTemplate jdbcTemplate;

  /** The get all. */
  private final String GET_ALL = "SELECT * FROM employee";

  /** The get by id. */
  private final String GET_BY_ID = "SELECT * FROM employee WHERE emp_id = ?";

  /** The delete by id. */
  private final String DELETE_BY_ID = "DELETE FROM employee WHERE emp_id = ?";

  /** The create. */
  private final String CREATE =
      "INSERT INTO employee"
          + " (benefit_id,first_name,last_name,email,phone_num,pay_grade,pay_step,salaried) VALUES"
          + " (?,?,?,?,?,?,?,?)";

  /** The update. */
  private final String UPDATE =
      "UPDATE employee SET benefit_id = ?, first_name = ?, last_name = ?, email = ?, phone_num = ?,"
          + " pay_grade = ?, pay_step = ?, salaried = ? WHERE emp_id = ?";

  /**
   * Instantiates a new employee service.
   *
   * @param jdbcTemplate the jdbc template
   */
  public EmployeeService(final JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
    datasource = this.jdbcTemplate.getDataSource();
  }

  /**
   * Gets the id.
   *
   * @param id the id
   * @return the id
   */
  public Employee getId(int id) {
    ResultSet rs;

    Employee result = null;

    try (Connection c = datasource.getConnection()) {
      PreparedStatement ps = c.prepareStatement(GET_BY_ID);

      ps.setInt(1, id);

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

  /**
   * Gets the all.
   *
   * @return the all
   */
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

  /**
   * Update.
   *
   * @param emp the emp
   */
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

  /**
   * Delete.
   *
   * @param emp the emp
   */
  public void delete(Employee emp) {
    try (Connection c = datasource.getConnection()) {
      PreparedStatement ps = c.prepareStatement(DELETE_BY_ID);

      ps.setInt(1, emp.getEmpId());

      ps.execute();
    } catch (final SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Creates the.
   *
   * @param emp the emp
   */
  public void create(Employee emp) {
    try (Connection c = datasource.getConnection()) {
      PreparedStatement ps = c.prepareStatement(CREATE);

      ps = empToPreparedStmt(emp, ps);

      ps.execute();
    } catch (final SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Emp to prepared stmt.
   *
   * @param e the e
   * @param ps the ps
   * @return the prepared statement
   * @throws SQLException the SQL exception
   */
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

  /**
   * Result to emp.
   *
   * @param rs the rs
   * @return the employee
   * @throws SQLException the SQL exception
   */
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
