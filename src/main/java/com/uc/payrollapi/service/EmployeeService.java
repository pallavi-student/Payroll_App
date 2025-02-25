package com.uc.payrollapi.service;


import com.uc.payrollapi.model.Employee;
import com.uc.payrollapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;  // Injecting Repository

    // Get all employees
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    // Get employee by ID
    public Optional<Employee> getEmployeeById(Long id) {
        return repository.findById(id);
    }

    // Add new employee
    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    // Update employee
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee Not Found"));
        employee.setName(employeeDetails.getName());
        employee.setSalary(employeeDetails.getSalary());
        return repository.save(employee);
    }

    // Delete employee
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
