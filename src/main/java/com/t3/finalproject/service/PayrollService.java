package com.t3.finalproject.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

// TODO: Auto-generated Javadoc
/** The Class PayrollService. */
@Configuration
@Service
public class PayrollService {

  /** The datasource. */
  protected DataSource datasource;

  /** The get salary. */
  private final String GET_SALARY = "SELECT ? FROM paygrade_salary WHERE grade = ?";

  /** The get hourly. */
  private final String GET_HOURLY = "SELECT ? FROM paygrade_hourly WHERE grade = ?";

  /** The jdbc template. */
  @Autowired private JdbcTemplate jdbcTemplate;

  /**
   * Instantiates a new payroll service.
   *
   * @param jdbcTemplate the jdbc template
   */
  public PayrollService(final JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
    datasource = this.jdbcTemplate.getDataSource();
  }

  /**
   * Gets the pay.
   *
   * @param grade the grade
   * @param step the step
   * @param isSalaried the is salaried
   * @return the pay
   */
  public int getPay(int grade, int step, boolean isSalaried) {
    ResultSet rs;

    int result = 0;

    try (Connection c = datasource.getConnection()) {
      PreparedStatement ps;

      if (isSalaried) {
        ps = c.prepareStatement(GET_SALARY);
      } else {
        ps = c.prepareStatement(GET_HOURLY);
      }

      ps.setString(1, "step" + step);
      ps.setInt(2, grade);

      rs = ps.executeQuery();

      if (rs.next() != false) {
        result = rs.getInt(1);
      }
    } catch (final SQLException e) {
      e.printStackTrace();
    }

    return result;
  }
}
