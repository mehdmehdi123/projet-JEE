package com.example.MS_Employes.dao;

import com.example.MS_Employes.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeDao extends JpaRepository<Employe, Long> {
    List<Employe> findByDepartmentId(Long departmentId);
}
