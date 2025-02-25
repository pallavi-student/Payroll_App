package com.uc.payrollapi.model;

import jakarta.persistence.*;

@Entity // 💡 Marks Employee as a JPA entity
@Table(name = "employees") // 💡 Table name in the database
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 💡 Auto-increment ID
    private Long id;

    private String name;
    private double salary;

    public Employee() {}

    public Employee(Long id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
