package com.uc.employee_payroll_app.service;

import com.uc.employee_payroll_app.model.Employee;
import com.uc.employee_payroll_app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return repository.findById(id);
    }

    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

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

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}

