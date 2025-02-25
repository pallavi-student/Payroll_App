package com.uc.payrollapi.service;


import com.uc.payrollapi.dto.EmployeeDTO;
import com.uc.payrollapi.model.Employee;
import com.uc.payrollapi.repository.EmployeeRepository;
import com.uc.payrollapi.util.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    // Get All Employees (returns DTO List)
    public List<EmployeeDTO> getAllEmployees() {
        return repository.findAll().stream()
                .map(EmployeeMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Get Employee by ID
    public EmployeeDTO getEmployeeById(Long id) {
        return repository.findById(id)
                .map(EmployeeMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Employee Not Found"));
    }

    // Add Employee
    public EmployeeDTO addEmployee(EmployeeDTO dto) {
        Employee employee = EmployeeMapper.toEntity(dto);
        return EmployeeMapper.toDTO(repository.save(employee));
    }

    // Update Employee
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO dto) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee Not Found"));
        employee.setName(dto.getName());
        employee.setSalary(dto.getSalary());
        return EmployeeMapper.toDTO(repository.save(employee));
    }

    // Delete Employee
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
