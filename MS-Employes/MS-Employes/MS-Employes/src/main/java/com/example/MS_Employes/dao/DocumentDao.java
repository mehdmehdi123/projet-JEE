package com.example.MS_Employes.dao;

import com.example.MS_Employes.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentDao extends JpaRepository<Document, Long> {
}
