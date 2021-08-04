package com.t3.finalproject.service;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.t3.finalproject.model.Employee;

@SpringBootTest
class FinalProjectApplicationTests {
	
	@Autowired
	EmployeeService service;

  @Test
  void getTest() {
	  Employee e = service.getId(15);
	  
	  assertEquals("andy", e.getFirstName());
  }
  
  @Test
  void deleteTest() {
	  Employee e = service.getId(15);
	  service.delete(e);
	  
	  e = service.getId(15);
	  assertEquals(null, e);
  }
  
}
