package com.example.MS_Departements.model;

import com.example.MS_Departements.dto.EmployeDto;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_department_id")
    private Departement parentDepartment;

    @OneToMany(mappedBy = "parentDepartment", cascade = CascadeType.ALL)
    private List<Departement> subDepartments = new ArrayList<>();

    private Long managerId;

    @Transient
    private List<EmployeDto> employees;

    public Departement() {
    }

    public Departement(Long id, String name, Departement parentDepartment, List<Departement> subDepartments, Long managerId, List<EmployeDto> employees) {
        this.id = id;
        this.name = name;
        this.parentDepartment = parentDepartment;
        this.subDepartments = subDepartments;
        this.managerId = managerId;
        this.employees = employees;
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

    public Departement getParentDepartment() {
        return parentDepartment;
    }

    public void setParentDepartment(Departement parentDepartment) {
        this.parentDepartment = parentDepartment;
    }

    public List<Departement> getSubDepartments() {
        return subDepartments;
    }

    public void setSubDepartments(List<Departement> subDepartments) {
        this.subDepartments = subDepartments;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public List<EmployeDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeDto> employees) {
        this.employees = employees;
    }
}
