package com.example.concordianapp.controller;

import com.example.concordianapp.model.Employee;
import com.example.concordianapp.repository.EmployeeRepository;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

  private final EmployeeRepository employeeRepository;

  @GetMapping
  public List<Employee> getEmployees() {
    Iterable<Employee> employees = employeeRepository.findAll();
    return StreamSupport.stream(employees.spliterator(), false).collect(Collectors.toList());
  }
}
