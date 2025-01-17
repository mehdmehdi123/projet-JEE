package com.example.MS_Employes.service;

import com.example.MS_Employes.dao.EmployeDao;
import com.example.MS_Employes.dto.DepartementDto;
import com.example.MS_Employes.dto.EmployeDto;
import com.example.MS_Employes.model.Employe;
import com.example.MS_Employes.proxy.DepartementClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class EmployeService {
    @Autowired
    private EmployeDao employeDao;

    @Autowired
    private DepartementClient departementClient;

    public Employe createEmploye(Employe employe) {
        return employeDao.save(employe);
    }

    public Employe getEmployeeById(Long id) {
        Employe employe = employeDao.findById(id).orElseThrow(() -> new NoSuchElementException("Employee not found"));

        // Récupérer le département de l'employé via Feign
        DepartementDto department = departementClient.getDepartmentById(employe.getDepartment().getId());
        employe.setDepartment(department);

        return employe;
    }

    public List<Employe> getAllEmployees() {
        return employeDao.findAll();
    }

    public Employe updateEmployee(Long id, Employe employeeDetails) {
        Employe employee = getEmployeeById(id);
        employee.setName(employeeDetails.getName());
        employee.setContractType(employeeDetails.getContractType());
        employee.setPosition(employeeDetails.getPosition());
        employee.setSalary(employeeDetails.getSalary());
        return employeDao.save(employee);
    }

    public void deleteEmployee(Long id) {
        Employe employee = getEmployeeById(id);
        employeDao.delete(employee);
    }

    public List<EmployeDto> getEmployeesByDepartmentId(Long departmentId) {
        // Rechercher les employés du département spécifique
        return employeDao.findByDepartmentId(departmentId)
                .stream()
                .map(employe -> new EmployeDto(
                        employe.getId(),
                        employe.getName(),
                        employe.getContractType(),
                        employe.getPosition(),
                        employe.getSalary()
                ))
                .collect(Collectors.toList());
    }
}
