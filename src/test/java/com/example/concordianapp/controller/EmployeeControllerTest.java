package com.example.concordianapp.controller;

import com.example.concordianapp.model.Employee;
import com.example.concordianapp.repository.EmployeeRepository;
import java.util.List;
import org.concordion.api.FullOGNL;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(ConcordionRunner.class)
@FullOGNL
public class EmployeeControllerTest {

  @ClassRule
  public static final SpringClassRule CLASS_RULE = new SpringClassRule();

  @Rule
  public final SpringMethodRule methodRule = new SpringMethodRule();

  @LocalServerPort
  private int port;

  @Autowired
  private EmployeeRepository employeeRepository;

  private final TestRestTemplate restTemplate = new TestRestTemplate();

  public void setUpEmployees(String id, String name, String email){
    Employee employee = new Employee();
    employee.setId(Long.valueOf(id.trim()));
    employee.setName(name.trim());
    employee.setEmail(email.trim());
    employeeRepository.save(employee);
  }

  public List<Employee> testEmployeeEndpoint() {
    var response = restTemplate.getForObject("http://localhost:" + port + "/employee", Employee[].class);
    return List.of(response);
  }
}