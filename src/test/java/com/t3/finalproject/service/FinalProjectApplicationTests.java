package com.t3.finalproject.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.t3.finalproject.model.Employee;

@SpringBootTest
class FinalProjectApplicationTests {

  @Autowired EmployeeService service;

  @Test
  void getTest() {
    Employee e = service.getId(15);

    assertEquals("andy", e.getFirstName());
  }

  @Test
  void getAllTest() {
    List<Employee> empList = service.getAll();

    assertEquals(7, empList.size());
  }

  @Test
  void deleteTest() {
    Employee e = service.getId(15);
    service.delete(e);
    e = service.getId(15);
    assertEquals(null, e);
  }

  @Test
  void createTest() {
    Employee testEmp =
        new Employee(22, 12, "name1", "name2", "email@provider.com", "1414292040", 2, 2, true);

    service.create(testEmp);

    assertEquals(testEmp.toString(), service.getId(22).toString());
  }

  @Test
  void updateTest() {
    Employee testEmp =
        new Employee(
            21, 15, "new_name1", "new_name2", "newemail@provider.com", "1111111111", 3, 3, false);

    service.update(testEmp);

    assertEquals(testEmp.toString(), service.getId(21).toString());
  }
}
