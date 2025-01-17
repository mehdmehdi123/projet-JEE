package com.example.MS_Departements.controller;

import com.example.MS_Departements.dto.AbsenceDto;
import com.example.MS_Departements.model.Departement;
import com.example.MS_Departements.proxy.AbsenceClient;
import com.example.MS_Departements.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartementController {
    @Autowired
    private DepartementService departmentService;

    @Autowired
    private AbsenceClient absenceClient;


    @PostMapping
    public ResponseEntity<Departement> createDepartment(@RequestBody Departement department) {
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.createDepartment(department));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departement> getDepartmentById(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }

    @GetMapping
    public ResponseEntity<List<Departement>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departement> updateDepartment(@PathVariable Long id, @RequestBody Departement departmentDetails) {
        return ResponseEntity.ok(departmentService.updateDepartment(id, departmentDetails));
    }

    @PutMapping("/{id}/manager/{managerId}")
    public ResponseEntity<Void> assignManager(@PathVariable Long id, @PathVariable Long managerId) {
        departmentService.assignManager(id, managerId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }

    // Obtenir les absences des employés d'un département
    @GetMapping("/{id}/absences")
    public ResponseEntity<List<AbsenceDto>> getAbsencesByDepartment(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.getAbsencesByDepartment(id));
    }

    @PostMapping("/{parentId}/sub-department")
    public ResponseEntity<Departement> addSubDepartment(@PathVariable Long parentId, @RequestBody Departement subDepartment) {
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.addSubDepartment(parentId, subDepartment));
    }

    @GetMapping("/{id}/hierarchy")
    public ResponseEntity<List<Departement>> getDepartmentHierarchy(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.getDepartmentHierarchy(id));
    }
}
