package com.example.MS_Departements.service;

import com.example.MS_Departements.dao.DepartementDao;
import com.example.MS_Departements.dto.AbsenceDto;
import com.example.MS_Departements.dto.EmployeDto;
import com.example.MS_Departements.model.Departement;
import com.example.MS_Departements.proxy.AbsenceClient;
import com.example.MS_Departements.proxy.EmployeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class DepartementService {
    @Autowired
    private DepartementDao departementDao;

    @Autowired
    private AbsenceClient absenceClient;

    @Autowired
    private EmployeClient employeClient;

    // Créer un nouveau département
    public Departement createDepartment(Departement department) {
        return departementDao.save(department);
    }

    // Obtenir un département par son ID
    public Departement getDepartmentById(Long id) {
        Departement department = departementDao.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Department not found"));

        // Récupérer la liste des employés depuis le MS-Employes
        List<EmployeDto> employees = employeClient.getEmployeesByDepartmentId(id);
        department.setEmployees(employees);

        return department;
    }

    // Obtenir la liste de tous les départements
    public List<Departement> getAllDepartments() {
        return departementDao.findAll();
    }

    // Mettre à jour un département
    public Departement updateDepartment(Long id, Departement departmentDetails) {
        Departement department = getDepartmentById(id);
        department.setName(departmentDetails.getName());
        department.setParentDepartment(departmentDetails.getParentDepartment());
        department.setManagerId(departmentDetails.getManagerId());
        return departementDao.save(department);
    }

    // Assigner un manager à un département
    public void assignManager(Long departmentId, Long managerId) {
        List<Departement> departments = departementDao.findAll();

        for (Departement department : departments) {
            if (department.getManagerId() != null && department.getManagerId().equals(managerId)) {
                throw new IllegalArgumentException("Manager is already assigned to another department");
            }
        }

        Departement department = getDepartmentById(departmentId);
        department.setManagerId(managerId);
        departementDao.save(department);
    }

    // Supprimer un département
    public void deleteDepartment(Long id) {
        Departement department = getDepartmentById(id);
        departementDao.delete(department);
    }

    // Obtenir les absences des employés d'un département
    public List<AbsenceDto> getAbsencesByDepartment(Long departmentId) {
        Departement department = getDepartmentById(departmentId);
        List<EmployeDto> employees = department.getEmployees();

        return employees.stream()
                .flatMap(employee -> absenceClient.getAbsencesByEmployeeId(employee.getId()).stream())
                .collect(Collectors.toList());
    }

    public Departement addSubDepartment(Long parentId, Departement subDepartment) {
        Departement parentDepartment = getDepartmentById(parentId);
        subDepartment.setParentDepartment(parentDepartment);
        return departementDao.save(subDepartment);
    }

    public List<Departement> getSubDepartments(Long parentId) {
        return departementDao.findByParentDepartmentId(parentId);
    }

    public List<Departement> getDepartmentHierarchy(Long departmentId) {
        Departement department = getDepartmentById(departmentId);
        List<Departement> hierarchy = new ArrayList<>();
        hierarchy.add(department);

        for (Departement subDepartment : department.getSubDepartments()) {
            hierarchy.addAll(getDepartmentHierarchy(subDepartment.getId()));
        }
        return hierarchy;
    }
}
