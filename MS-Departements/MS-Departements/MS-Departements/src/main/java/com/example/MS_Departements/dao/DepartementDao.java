package com.example.MS_Departements.dao;

import com.example.MS_Departements.model.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartementDao extends JpaRepository<Departement, Long> {
    List<Departement> findByParentDepartmentId(Long parentId);
}
