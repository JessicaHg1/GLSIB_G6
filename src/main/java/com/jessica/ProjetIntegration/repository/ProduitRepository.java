package com.jessica.ProjetIntegration.repository;

import com.jessica.ProjetIntegration.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Integer > {

    @Query(value = "UPDATE produit  SET qte_stock = qte_stock+quantite where id = ?", nativeQuery = true)
    void updateQuantiteStock( int id, int quantite);
}
