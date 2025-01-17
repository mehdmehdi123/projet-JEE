package com.example.MS_Absences.service;

import com.example.MS_Absences.dao.AbsenceDao;
import com.example.MS_Absences.dto.EmployeDto;
import com.example.MS_Absences.model.Absence;
import com.example.MS_Absences.proxy.EmployeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbsenceService {
    @Autowired
    private final AbsenceDao absenceDao;

    @Autowired
    private EmployeClient employeClient;

    public AbsenceService(AbsenceDao absenceDao) {
        this.absenceDao = absenceDao;
    }

    // Ajouter une demande d'absence
    public Absence createAbsence(Absence absence) {
        absence.setApproved(false);
        return absenceDao.save(absence);
    }

    // Valider une demande d'absence
    public Absence approveAbsence(Long id) {
        Absence absence = absenceDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Absence not found"));
        absence.setApproved(true);
        return absenceDao.save(absence);
    }

    // Lister les absences d'un employé
    public List<Absence> getAbsencesByEmployeeId(Long employeeId) {
        EmployeDto employe = employeClient.getEmployeeById(employeeId);
        return absenceDao.findByEmployeeId(employeeId);
    }
}
