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
    private EmployeeRepository repository;

    // Fetch all employees
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    // Fetch employee by ID
    public Optional<Employee> getEmployeeById(Long id) {
        return repository.findById(id);
    }

    // Add a new employee
    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    // Update employee details
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Optional<Employee> optionalEmployee = repository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();
            existingEmployee.setName(employeeDetails.getName());
            existingEmployee.setEmail(employeeDetails.getEmail());
            existingEmployee.setSalary(employeeDetails.getSalary());
            return repository.save(existingEmployee);
        }
        return null;
    }

    // Delete an employee by ID
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
