package com.example.MS_Employes.dto;

public class EmployeDto {
    private Long id;
    private String name;
    private String contractType;
    private String position;
    private Double salary;

    public EmployeDto() {
    }

    public EmployeDto(Long id, String name, String contractType, String position, Double salary) {
        this.id = id;
        this.name = name;
        this.contractType = contractType;
        this.position = position;
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

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
