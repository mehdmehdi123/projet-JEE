package com.example.MS_Employes.dto;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class DepartementDto {
    private Long id;
    private String name;
    private DepartementDto parentDepartment;
    private List<DepartementDto> subDepartments = new ArrayList<>();
    private Long managerId;
    @Transient
    private List<EmployeDto> employees;

    public DepartementDto() {
    }

    public DepartementDto(Long id, String name, DepartementDto parentDepartment, List<DepartementDto> subDepartments, Long managerId, List<EmployeDto> employees) {
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

    public DepartementDto getParentDepartment() {
        return parentDepartment;
    }

    public void setParentDepartment(DepartementDto parentDepartment) {
        this.parentDepartment = parentDepartment;
    }

    public List<DepartementDto> getSubDepartments() {
        return subDepartments;
    }

    public void setSubDepartments(List<DepartementDto> subDepartments) {
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
