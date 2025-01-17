package com.example.MS_Absences.dao;

import com.example.MS_Absences.model.Absence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AbsenceDao extends JpaRepository<Absence, Long> {
    List<Absence> findByEmployeeId(Long employeeId);
}
