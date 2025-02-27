package com.uc.payrollapi.service;
import com.uc.payrollapi.dto.EmployeeDTO;
import com.uc.payrollapi.model.Employee;
import com.uc.payrollapi.repository.EmployeeRepository;
import com.uc.payrollapi.util.EmployeeMapper;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@Validated
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    public List<EmployeeDTO> getAllEmployees() {
        log.info("Fetching all employees from the database");
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public EmployeeDTO getEmployeeById(Long id) {
        log.info("Fetching employee with ID: {}", id);
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        return employeeOptional.map(employeeMapper::toDTO).orElse(null);
    }

    public EmployeeDTO createEmployee(@Valid EmployeeDTO employeeDTO) {
        log.info("Creating new employee: {}", employeeDTO);
        Employee employee = employeeMapper.toEntity(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.toDTO(savedEmployee);
    }

    public EmployeeDTO updateEmployee(Long id, @Valid EmployeeDTO employeeDTO) {
        log.info("Updating employee with ID: {}", id);
        Optional<Employee> existingEmployeeOptional = employeeRepository.findById(id);

        if (existingEmployeeOptional.isPresent()) {
            Employee existingEmployee = existingEmployeeOptional.get();
            existingEmployee.setName(employeeDTO.getName());
            existingEmployee.setEmail(employeeDTO.getEmail()); //  Ensure email is updated
            existingEmployee.setSalary(employeeDTO.getSalary()); // Ensure salary is updated
            Employee updatedEmployee = employeeRepository.save(existingEmployee);
            return employeeMapper.toDTO(updatedEmployee);
        }
        log.warn("Employee with ID {} not found!", id);
        return null;
    }

    public void deleteEmployee(Long id) {
        log.info("Deleting employee with ID: {}", id);
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        } else {
            log.warn("Employee with ID {} not found!", id);
        }
    }
}