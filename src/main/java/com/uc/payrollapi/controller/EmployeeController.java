package com.uc.payrollapi.controller;


import com.uc.payrollapi.dto.EmployeeDTO;
import com.uc.payrollapi.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
@Validated
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Create Employee
    @PostMapping
    public ResponseEntity<String> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        employeeService.createEmployee(employeeDTO);
        return ResponseEntity.ok("Employee created successfully");
    }

    // Update Employee
    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDTO employeeDTO) {
        employeeService.updateEmployee(id, employeeDTO);
        return ResponseEntity.ok("Employee updated successfully");
    }
}