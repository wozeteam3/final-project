package com.t3.finalproject;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinalProjectApplication {

  public static void main(String[] args) {
    SpringApplication.run(FinalProjectApplication.class, args);
    
    final String createSPG = "INSERT INTO paygrade_salary (step0, step1, step2, step3, step4) VALUES(?, ?, ?, ?, ?)";
    final String increaseSPS = "UPDATE employee SET pay_step = ? WHERE emp_id = ?";
    final String increaseSPG = "UPDATE employee SET pay_grade = ? WHERE emp_id = ?";
    
    public void createSalaryPayGrade(int st0, int st1, int st2, int st3, int st4) {
    	try(
    			Connection c = db.getconnection();
    			PreparedStatement ps = c.prepareStatement(createSPG)
    		){
    		ps.setString(1, st0);
    		ps.setString(2, st1);
    		ps.setString(3, st2);
    		ps.setString(4, st3);
    		ps.setString(5, st4);
    		
    		ps.executeUpdate();
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
  }
}
