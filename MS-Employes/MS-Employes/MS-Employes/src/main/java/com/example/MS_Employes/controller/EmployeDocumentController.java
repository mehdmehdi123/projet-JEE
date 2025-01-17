package com.example.MS_Employes.controller;

import com.example.MS_Employes.model.Employe;
import com.example.MS_Employes.service.EmployeDocumentService;
import com.example.MS_Employes.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/employees/{employeeId}/documents")
public class EmployeDocumentController {
    @Autowired
    private EmployeService employeService;

    @Autowired
    private EmployeDocumentService employeeDocumentService;

    // Endpoint pour télécharger un document et l'associer à un employé
    @PostMapping
    public ResponseEntity<String> uploadDocument(
            @PathVariable Long employeeId,
            @RequestParam("file") MultipartFile file) {

        try {
            // Vérification de l'existence de l'employé
            Employe employe = employeService.getEmployeeById(employeeId);

            // Appel du service pour gérer l'upload du fichier
            employeeDocumentService.uploadDocument(employe, file);

            return ResponseEntity.ok("File uploaded successfully for employee " + employe.getName());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to upload file: " + e.getMessage());
        }
    }
}
