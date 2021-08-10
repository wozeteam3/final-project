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


@Configuration
@Service
public class PayrollService {

  protected DataSource datasource;

  private final String GET_SALARY = "SELECT ? FROM paygrade_salary WHERE grade = ?";
  private final String GET_HOURLY = "SELECT ? FROM paygrade_hourly WHERE grade = ?";

  @Autowired private JdbcTemplate jdbcTemplate;

  public PayrollService(final JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
    datasource = this.jdbcTemplate.getDataSource();
  }

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
