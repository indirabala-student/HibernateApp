package org.example;

import jakarta.persistence.*;


@Entity
@Table(name = "employee", uniqueConstraints = @UniqueConstraint(columnNames = {"emp_name","emp_department"}))
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "emp_name", nullable = false)
    private String name;

    @Column(name = "emp_department", nullable = false)
    private String department;

    public Employee() {
    }

    public Employee(String name, String department) {
        this.name=name;
        this.department=department;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
