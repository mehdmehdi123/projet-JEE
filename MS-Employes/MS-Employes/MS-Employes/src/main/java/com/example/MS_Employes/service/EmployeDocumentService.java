package com.example.MS_Employes.service;

import com.example.MS_Employes.dao.DocumentDao;
import com.example.MS_Employes.model.Document;
import com.example.MS_Employes.model.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class EmployeDocumentService {
    // Dossier où les fichiers seront stockés
    private static final String DOCUMENTS_DIRECTORY = "C:\\Users\\wiamb\\Downloads";

    @Autowired
    private DocumentDao documentDao; // Injection du repository pour les documents

    // Méthode pour uploader un document
    public void uploadDocument(Employe employe, MultipartFile file) throws IOException {
        // Créer un dossier spécifique à l'employé si nécessaire
        File employeeDir = new File(DOCUMENTS_DIRECTORY + employe.getId());
        if (!employeeDir.exists()) {
            employeeDir.mkdirs();
        }

        // Enregistrer le fichier
        File destinationFile = new File(employeeDir, file.getOriginalFilename());
        file.transferTo(destinationFile);

        // Créer l'entité Document et l'associer à l'employé
        Document document = new Document();
        document.setFileName(file.getOriginalFilename());
        document.setFilePath(destinationFile.getAbsolutePath());
        document.setEmploye(employe);

        // Sauvegarder le document dans la base de données
        documentDao.save(document);
    }
}
