package com.jessica.ProjetIntegration.repository;

import com.jessica.ProjetIntegration.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Integer > {
}
