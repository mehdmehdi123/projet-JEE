package com.example.MS_Employes.model;

import jakarta.persistence.*;

@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;  // Nom du fichier
    private String filePath;  // Chemin du fichier

    @ManyToOne
    private Employe employe;  // Relation avec l'employé

    public Document() {
    }

    public Document(Long id, String fileName, String filePath, Employe employe) {
        this.id = id;
        this.fileName = fileName;
        this.filePath = filePath;
        this.employe = employe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
}
