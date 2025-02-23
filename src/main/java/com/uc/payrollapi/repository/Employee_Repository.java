package com.uc.employee_payroll_app.repository;



import com.uc.employee_payroll_app.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Employee_Repository extends JpaRepository<Employees, Long> {
}

