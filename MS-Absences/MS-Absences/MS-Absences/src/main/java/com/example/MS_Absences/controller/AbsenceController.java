package com.example.MS_Absences.controller;

import com.example.MS_Absences.dto.AbsenceRequest;
import com.example.MS_Absences.model.Absence;
import com.example.MS_Absences.service.AbsenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/absences")
public class AbsenceController {
    private final AbsenceService absenceService;

    public AbsenceController(AbsenceService absenceService) {
        this.absenceService = absenceService;
    }

    // Endpoint pour créer une absence
    @PostMapping
    public ResponseEntity<Absence> createAbsence(@RequestBody AbsenceRequest request) {
        Absence absence = new Absence();
        absence.setEmployeeId(request.getEmployeeId());
        absence.setStartDate(request.getStartDate());
        absence.setEndDate(request.getEndDate());
        absence.setType(request.getType());
        return ResponseEntity.ok(absenceService.createAbsence(absence));
    }

    // Endpoint pour valider une absence
    @PutMapping("/{id}/approve")
    public ResponseEntity<Absence> approveAbsence(@PathVariable Long id) {
        return ResponseEntity.ok(absenceService.approveAbsence(id));
    }

    // Endpoint pour obtenir les absences d'un employé
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<Absence>> getAbsencesByEmployeeId(@PathVariable Long employeeId) {
        return ResponseEntity.ok(absenceService.getAbsencesByEmployeeId(employeeId));
    }
}
