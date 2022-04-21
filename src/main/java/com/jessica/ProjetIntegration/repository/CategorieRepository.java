package com.jessica.ProjetIntegration.repository;

import com.jessica.ProjetIntegration.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
}
