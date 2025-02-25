package com.uc.payrollapi.service;

import com.uc.payrollapi.model.Employee;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>();

    //  Add dummy data when the application starts
    @PostConstruct
    public void init() {
        employees.add(new Employee(1L, "John Doe", 50000));
        employees.add(new Employee(2L, "Jane Smith", 60000));
    }

    //  Get all employees
    public List<Employee> getAllEmployees() {
        return employees;
    }

    //  Add a new employee
    public Employee addEmployee(Employee employee) {
        employee.setId((long) (employees.size() + 1)); // Assign ID manually
        employees.add(employee);
        return employee;
    }
}
